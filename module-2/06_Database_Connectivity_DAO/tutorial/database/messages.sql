DROP TABLE IF EXISTS message;

CREATE TABLE message (
        
        id serial primary key,
        title varchar(255) not null,
        body text not null,
        dateAdded timestamp
);

INSERT INTO message (id, title, body, dateAdded) VALUES
        (DEFAULT, 'First Message', 'Hello World', current_timestamp),
        (DEFAULT, 'Hello', 'Yay, I am finally sending messages', null),
        (DEFAULT, 'Want to get lunch?', 'How about noon?  We can sneak out the side door to avoid the boss', current_timestamp);