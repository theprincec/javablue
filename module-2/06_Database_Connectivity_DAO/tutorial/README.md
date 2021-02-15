# DAO Tutorial

The DAO (Data Access Object) Pattern contains 3 parts.  

1. Data Object - a simple Java Object that represents 1 row returned by the query, usually a table.
2. DAO Interface - an interface that defines the CRUD operations available for the DAO.
3. DAO Implementation class - implements the DAO interface and contains the JDBC functionality to interact with the database in the method overrides.

## Settting up the Database

There is a database schema file, messages.sql, in the database folder of the project.

In Terminal:

1. cd to the database folder containing the messages.sql schema file.
2. `createdb -U postgres messages`
3. `psql -U postgres -d messages -f messages.sql`

The database contains 1 table with 3 rows of data.  The table is defined as:

```sql
CREATE TABLE message ( 
        id serial primary key,
        title varchar(255) not null,
        body text not null,
        dateAdded timestamp
);
```

## Step 1 - Create the Data Object

The Data Object will represent 1 row from the table.

In Eclipse create a new class named `Message` in the `package com.techelevator.messages`.

Add private member variables for each column in the database.  The data type of each member variable should be one that can hold the same type of data as the SQL table in Java.

```java
private long id;
private String title;
private String body;
private LocalDate dateAdded;
```

Generate or create Getters and Setters for each member variable.

## Step 2 - Create the DAO Interface

The DAO interface will list methods that the DAO implementation class will provide to access the data.  The Data Class will be used as the primary argument and return type, however, other data types may be used as appropriate.

Create a new interface named `MessageDao` in `com.techelevator.messages`.

Our interface will create a contract that the implemetation class will provide a method to get all messages, get a single message by id, save a message, update a message, and delete a message.  

Add the following method signatures to the interface.

```java
List<Message> getAllMessages();
Message getMessage(long messageId);
void save(Message message);
void update(Message message);
void delete(long messageId);
```

## Step 3 - Create the DAO Implementation class

The DAO Implementation class will implement the DAO interface and provide functionality that interacts with the database for each method required by the interface.

Create a new class named `JdbcMessageDao` in `com.techelevator.messages`.

In the JdbcMessageDao class implement the MessageDao interface.

```java
public class JdbcMessageDao implements MessageDao
```

Add a private member variable for the `JdbcTemplate` and a constructor that accepts a `javax.sql.DataSource` as an argument and uses it to instantiate a new `JdbcTemplate` and assign it to the member variable.

```java
private JdbcTemplate jdbcTemplate;

public JdbcMessageDao(DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
}
```

Add the Overrides for each method in the interface either by using the Eclipse 'add unimplemented methods' helper or by copying from below.

```java
@Override
public List<Message> getAllMessages() {
    // TODO Auto-generated method stub
    return null;
}

@Override
public Message getMessage(long messageId) {
    // TODO Auto-generated method stub
    return null;
}

@Override
public void save(Message message) {
    // TODO Auto-generated method stub
}

@Override
public void update(Message message) {
    // TODO Auto-generated method stub
}

@Override
public void delete(long messageId) {
    // TODO Auto-generated method stub
}
```

### Implementing Get All Messages

In the `public List<Message> getAllMessages()` method body:

Since the method returns a List of Messages, create a new ArrayList to hold the results.

```java
List<Message> messages = new ArrayList<Message>();
```

Create a SQL statement to select all rows from the messages table.  This is best done and tested in DbVisualizer.

In the method assign the SQL statement as a String to a variable. 

```java
String sql = "SELECT id, title, body, dateAdded FROM message";
```

Next use the queryForRowSet() method of the jdbcTemplate member variable.  Pass it the sql and and store its result in a variable defined as SqlRowSet.

```java
SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
```

The SqlRowSet returned contains the rows from the table returned by the query.  To get to each row the next() method must be called.  The next() method must be called at least once to get to the first row returned.  If the SqlRowSet has another row it will return true and if there are no further rows it will return false.

Create a while loop that loops while the next() method returns true.

```java
while (results.next()) {

}
```

Create a private method to map a single row from the SqlRowSet to the Java Data Object and return it.  This will be a private method so it can be reused by any method in the DAO that needs to do the same mapping.

Since our Data Object uses a java LocalDate and SQL will return a SqlDate the toLocalDate() method must be called to convert it.  However, the SqlDate may be null, which will cause a nullPointerException, so the value should only be mapped if it is not null.

```java
private Message mapRowToMessage(SqlRowSet row) {

    Message message = new Message();
    message.setId( row.getLong("id") );
    message.setTitle( row.getString("title") );
    message.setBody( row.getString("body") );

    /* The date may be null in the database and we need to use the toLocalDate() method, so check if it is null and only do the assignment if it is not.
    */
    if ( row.getDate("dateAdded") != null) {
        message.setDateAdded( row.getDate("dateAdded").toLocalDate() );
    }

    return message;
}
```

In the while loop, pass the results to the private mapping method.  For each time through the loop the next() method will advance the results to the next row and that row will be mapped to a new Message Data Object.  When the method returns the Data Object add it to the ArrayList.

```java
while (results.next()) {
    messages.add( mapRowToMessage(results) );
}
```

Finally use the now populated ArrayList as the return of the method.

```java
return messages;
```

Your final geAllMessages() method should look like this:

```java
@Override
public List<Message> getAllMessages() {
    List<Message> messages = new ArrayList<Message>();
    String sql = "SELECT id, title, body, dateAdded FROM message";
    SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
    while (results.next()) {
        messages.add( mapRowToMessage(results) );
    }
    return messages;
}
```

### Implementing Get Message by Id

In the `public Message getMessage(long messageId)` method body:

Since the method returns a Message, instantiate a new Message and set it to null.

```java
Message message = null;
```

Create a SQL statement to select all rows from the messages table.  This is best done and tested in DbVisualizer.

In the method assign the SQL statement as a String to a variable.  The id will be passed as an argument so make it a parameter by replacing it in the query with a ?

```java
String sql = "SELECT id, title, body, dateAdded FROM message WHERE id = ?";
```

Next use the queryForRowSet() method of the jdbcTemplate member variable.  Pass it the sql and the messageId, then store its result in a variable defined as SqlRowSet.

```java
SqlRowSet results = jdbcTemplate.queryForRowSet(sql, messageId);
```

The SqlRowSet returned contains the rows from the table returned by the query.  To get to each row the next() method must be called.  The next() method must be called at least once to get to the first row returned.  If the SqlRowSet has another row it will return true and if there are no further rows it will return false.

Create a if statement with next() so the result is only mapped if a result is returned by the query.  The private mapping method already created can be used to map the row and the result assigned to the Message variable.

```java
if (results.next()) {
    message = mapRowToMessage(results);
}
```

Finally return the Message object.

```java
return message;
```

Your final getMessage() method should look like this:

```java
@Override
public Message getMessage(long messageId) {
    Message message = null;
    String sql = "SELECT id, title, body, dateAdded FROM message WHERE id = ?";
    SqlRowSet results = jdbcTemplate.queryForRowSet(sql, messageId);
    if (results.next()) {
        message = mapRowToMessage(results);
    }
    return message;
}
```

### Implementing save

In the `public void save(Message message)` method body:

Create a SQL statement to insert a new row into the messages table.  This is best done and tested in DbVisualizer.

In the method assign the SQL statement as a String to a variable.  Use DEFAULT for the generated id and ? for the other columns in the values to make them parameters.  Add the RETURNING id clause to the statement, which will immediately do a SELECT after inserting the row and return the generated id.

```java
String sql = "INSERT INTO message (id, title, body, dateAdded) VALUES (DEFAULT, ?, ?, ?) RETURNING id";
```

Use the jdbcTemplate queryForRowSet() method to execute the insert, passing it the sql and the values for the paramters.  The values can be retrieved using the getters of the Message object passed as an argument to the method.  The values must be added in the same order as the columsn the represent.  

NOTE: normally an insert statement would be executed using the update() method of the jdbcTemplate, however, when it has the returning clause it will return a RowSet so it must use queryForRowSet() in this case.

```java
SqlRowSet results = jdbcTemplate.queryForRowSet(sql, message.getTitle(), message.getBody(), message.getDateAdded());
```

Since if no exception was thrown we know that the insert was successful, so call next() on the SqlRowSet results to advance it to the first row, which contains the returned id.

```java
results.next();
```

Use the results.getLong() method to get the id from the results by column name and assign using the setId() method of the Message object.  Since Java passed the Message object by reference this will allow the user of the method to access the generated id using the Message object getter() once the method has returned.

```java
message.setId( results.getLong("id") );
```

The save method does not need a return statement since it is defined as void.  

Your completed save() method should look like this:

```java
@Override
public void save(Message message) {
    String sql = "INSERT INTO message (id, title, body, dateAdded) VALUES (DEFAULT, ?, ?, ?) RETURNING id";
    SqlRowSet results = jdbcTemplate.queryForRowSet(sql, message.getTitle(), message.getBody(), message.getDateAdded());
    results.next();
    message.setId( results.getLong("id") );
}
```

### Implementing update

In the `public void update(Message message)` method body:

Create a SQL statement to update a row the messages table.  This is best done and tested in DbVisualizer.

In the method assign the SQL statement as a String to a variable.  Use ? for all of the values to turn them into parameters.

```java
String sql = "UPDATE message SET title = ?, body = ?, dateAdded = ? WHERE id = ?";
```

Use the jdbcTemplate update() method to execute the query.  Pass the update() method the sql and the values for each paramter.  The order of the values passed for the paramters must be in the same order as they are used in the query.  The values can be retrieved using the getters of the Message object passed to the method.

```java
jdbcTemplate.update(sql, message.getTitle(), message.getBody(), message.getDateAdded(), message.getId());
```

Since the update() method is defined as void no return is needed.

Your final update() method should look like this:

```java
@Override
public void update(Message message) {
    String sql = "UPDATE message SET title = ?, body = ?, dateAdded = ? WHERE id = ?";
    jdbcTemplate.update(sql, message.getTitle(), message.getBody(), message.getDateAdded(), message.getId());
}
```

### Implementing delete

In the `public void delete(long messageId)` method body:

Create a SQL statement to delete a row from the messages table.  This is best done and tested in DbVisualizer.

In the method assign the SQL statement as a String to a variable.  Use ? for all of the values to turn them into parameters.

```java
String sql = "DELETE FROM message WHERE id = ?";
```

Use the jdbcTemplate update() method to execute the query.  Pass the update() method the sql and the messageId passed to the method 

```java
jdbcTemplate.update(sql,messageId);
```

Since the delete() method is defined as void no return is needed.

Your final delete() method should look like this:

```java
@Override
public void delete(long messageId) {
    String sql = "DELETE FROM message WHERE id = ?";
    jdbcTemplate.update(sql,messageId);
}
```

## Creating a Test Class to verify your DAO

If you like, you can create a class with a main() method that you can run as a Java application to instantiate and test your DAO methods.

To create a DataSource:

```java
BasicDataSource dataSource = new BasicDataSource();
dataSource.setUrl("jdbc:postgresql://localhost:5432/messages");
dataSource.setUsername("postgres");
dataSource.setPassword("postgres1");
```

When creating the DataSource take care to import the correct BasicDataSource class:

```java
import org.apache.commons.dbcp2.BasicDataSource;
```

And to correctly set the database name in the connection string:

```java
dataSource.setUrl("jdbc:postgresql://localhost:5432/messages");
```

Once you have the dataSource created use the DAO interface as a data type for a variable then instanatiate the DAO implementation class, pass the dataSource to the constructor, and assign it to the variable.

```java
MessageDao messageDao = new JdbcMessageDao(dataSource);
```

You can now use the messageDao object to access your implemented methods and read, write, update, and delete from the database within your application.  

I encourage you to create your own application that uses the MessageDao.  

Sample basic usage of the MessageDao methods:

```java
public static void main(String[] args) {
    
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setUrl("jdbc:postgresql://localhost:5432/messages");
    dataSource.setUsername("postgres");
    dataSource.setPassword("postgres1");

    MessageDao messageDao = new JdbcMessageDao(dataSource);

    System.out.println("----- GET ALL MESSAGES ---------");

    List<Message> messages = messageDao.getAllMessages();

    for (Message message : messages) {
        System.out.println("id=" + message.getId() + 
            " title=" + message.getTitle() + 
            " body=" + message.getBody() + " dateAdded=" 
            + message.getDateAdded() );
    }

    System.out.println();
    System.out.println("----- GET MESSAGE BY ID ---------");

    Message message = messageDao.getMessage(1);

    System.out.println("id=" + message.getId() + 
        " title=" + message.getTitle() + 
        " body=" + message.getBody() + 
        " dateAdded=" + message.getDateAdded() );

    System.out.println();
    System.out.println("----- INSERT MESSAGE ---------");

    Message newMessage = new Message();
    newMessage.setTitle("Message from Java App");
    newMessage.setBody("This is a message from a Java application");
    newMessage.setDateAdded( LocalDate.now() );

    messageDao.save( newMessage );

    System.out.println("New Message Id=" + newMessage.getId());

    System.out.println();
    System.out.println("----- UPDATE MESSAGE ---------");

    newMessage.setTitle("The Title as updated");
    newMessage.setBody("The body was updated");

    messageDao.update(newMessage);

    System.out.println();
    System.out.println("----- DELETE MESSAGE ---------");

    long messageId = newMessage.getId();

    messageDao.delete(messageId);

}
```
