-- CREATE DATABASE contacts;

-- TABLEs must be dropped in order such that tables with a foreign key relationship
-- are dropped before the table to which they are related.  For example, email has a FK to contact, so 
-- email must be dropped before contact.
DROP TABLE IF EXISTS contact_address;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS email;
DROP TABLE IF EXISTS contact;

CREATE TABLE contact (
        contact_id serial primary key,
        first_name varchar(32),
        last_name varchar(32) not null
);

CREATE TABLE email (
        email_id serial primary key,
        contact_id int not null,
        email_address varchar(255) not null,
        type varchar(10) DEFAULT 'PERSONAL',
        description varchar(255),
        
        constraint fk_contact_id_email foreign key (contact_id) references contact(contact_id),
        constraint chk_type check ( type IN ('PERSONAL', 'WORK', 'OTHER') ),
        constraint chk_descript check ( (type = 'OTHER' AND description IS NOT NULL) OR (type <> 'OTHER' AND description IS NULL) )
             
);

CREATE TABLE address (
        address_id serial primary key,
        line_1 varchar(255) not null,
        line_2 varchar(255),
        city varchar(40) not null,
        district varchar(100) not null,
        postal_code varchar(20) not null,
        country_code char(3) not null,
        type varchar(10) DEFAULT 'HOME'
);

CREATE TABLE contact_address (
        contact_id int,
        address_id int,
        
        PRIMARY KEY (contact_id, address_id),
        constraint fk_contact_address_contact_id foreign key (contact_id) references contact(contact_id),
        constraint fk_contact_address_address_id foreign key (address_id) references address(address_id)
);