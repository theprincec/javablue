--DROP DATABASE contacts;
--CREATE DATABASE contacts;

-- TABLEs must be dropped in order such that tables with a foreign key relationship
-- are dropped before the table to which they are related.  For example, email has a FK to contact, so 
-- email must be dropped before contact.
DROP TABLE IF EXISTS contact_address;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS email;
DROP TABLE IF EXISTS phone;
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
        constraint chk_type_email check ( type IN ('PERSONAL', 'WORK', 'OTHER') ),
        constraint chk_description_email check ( (type = 'OTHER' AND description IS NOT NULL) OR (type <> 'OTHER' AND description IS NULL) )
             
);

CREATE TABLE phone (
        phone_id serial primary key,
        contact_id int not null,
        phone_number varchar(255) not null,
        type varchar(10) DEFAULT 'MOBILE',
        description varchar(255),
        
        constraint fk_contact_id_phone foreign key (contact_id) references contact(contact_id),
        constraint chk_type_phone check ( type IN ('HOME', 'WORK', 'MOBILE', 'OTHER') ),
        constraint chk_description_phone check ( (type = 'OTHER' AND description IS NOT NULL) OR (type <> 'OTHER' AND description IS NULL) )
             
);

CREATE TABLE address (
        address_id serial primary key,
        line_1 varchar(255) not null,
        line_2 varchar(255),
        city varchar(40) not null,
        district varchar(100) not null,
        postal_code varchar(20) not null,
        country_code char(3) not null,
        type varchar(10) DEFAULT 'HOME',
        
        constraint chk_type_address check ( type IN ('HOME', 'WORK', 'SHIPPING', 'BILLING', 'OTHER') )
);

CREATE TABLE contact_address (
        contact_id int,
        address_id int,
        
        PRIMARY KEY (contact_id, address_id),
        constraint fk_contact_address_contact_id foreign key (contact_id) references contact(contact_id),
        constraint fk_contact_address_address_id foreign key (address_id) references address(address_id)
);


-- These INSERTs use the CURRVAL(sequence) function to get the last value used for the sequence
-- without incrementing it.  This allows for the entries to be added using the sequence so it is current
-- the next time it is used.   WARNING: This only works if the order of the INSERTS is maintained.  If the order is 
-- changed, then it will associate the incorrect ids.  CAUTION: This is 1 ways of using sequences in a schema script, but 
-- should only be used when we are sure there are no other users connected to a database that may be INSERTING other records,
-- which may cause CURRVAL() to return their use of the sequence instead of ours.  In this script is is safe to use, because
-- the earlier portion of the schema drops and creates the database when run.  

-- INSERT Dave Warthog
INSERT INTO contact (contact_id, first_name, last_name) 
        VALUES (DEFAULT, 'Dave', 'Warthog');
INSERT INTO address (address_id, line_1, line_2, city, postal_code, district, country_code, type)
        VALUES (DEFAULT, '1245 High Street', 'Apt 51', 'Columbus', '43201', 'OH', 'USA', 'HOME');
INSERT INTO contact_address (contact_id, address_id) 
        VALUES ( CURRVAL('contact_contact_id_seq'), CURRVAL('address_address_id_seq') );
INSERT INTO phone ( phone_id, contact_id, phone_number, type, description)
        VALUES ( DEFAULT, CURRVAL('contact_contact_id_seq'), '614-555-1212', 'MOBILE', null);
INSERT INTO email (email_id, contact_id, email_address, type, description) 
        VALUES ( DEFAULT, CURRVAL('contact_contact_id_seq'), 'warthog@warthogrules.com', 'PERSONAL', null);
        
-- INSERT Rayboy Jones
INSERT INTO contact (contact_id, first_name, last_name)
        VALUES (DEFAULT, 'Ratboy', 'Jones');
INSERT INTO address (address_id, line_1, line_2, city, postal_code, district, country_code, type)
        VALUES (DEFAULT, 'Under the front street bridge', null, 'Columbus', '43201', 'OH', 'USA', 'HOME');
INSERT INTO contact_address (contact_id, address_id) 
        VALUES ( CURRVAL('contact_contact_id_seq'), CURRVAL('address_address_id_seq') );
        
INSERT INTO address (address_id, line_1, line_2, city, postal_code, district, country_code, type)
        VALUES (DEFAULT, 'OSU Tunnels', 'North Oval Entrance', 'Columbus', '43201', 'OH', 'USA', 'OTHER');
INSERT INTO contact_address (contact_id, address_id) 
        VALUES ( CURRVAL('contact_contact_id_seq'), CURRVAL('address_address_id_seq') );          
INSERT INTO phone ( phone_id, contact_id, phone_number, type, description)
        VALUES ( DEFAULT, CURRVAL('contact_contact_id_seq'), '614-555-7892', 'MOBILE', null);
INSERT INTO phone ( phone_id, contact_id, phone_number, type, description)
        VALUES ( DEFAULT, CURRVAL('contact_contact_id_seq'), '888-555-8277', 'OTHER', 'Payphone');
INSERT INTO email (email_id, contact_id, email_address, type, description) 
        VALUES ( DEFAULT, CURRVAL('contact_contact_id_seq'), 'ratboy@aol.com', 'PERSONAL', null);   
        
-- INSERT Tall Bobby
INSERT INTO contact (contact_id, first_name, last_name)
        VALUES (DEFAULT, 'Tall', 'Bobby');
INSERT INTO address (address_id, line_1, line_2, city, postal_code, district, country_code, type)
        VALUES (DEFAULT, '52A 5th Ave', null, 'Columbus', '43220', 'OH', 'USA', 'WORK');
INSERT INTO contact_address (contact_id, address_id) 
        VALUES ( CURRVAL('contact_contact_id_seq'), CURRVAL('address_address_id_seq') );
INSERT INTO phone ( phone_id, contact_id, phone_number, type, description)
        VALUES ( DEFAULT, CURRVAL('contact_contact_id_seq'), '614-555-5782', 'HOME', null);
INSERT INTO email (email_id, contact_id, email_address, type, description) 
        VALUES ( DEFAULT, CURRVAL('contact_contact_id_seq'), 'tallguy@bobbyrocks.com', 'WORK', null);
        
-- INSERT Jenny Jones
INSERT INTO contact (contact_id, first_name, last_name)
        VALUES (DEFAULT, 'Jenny', 'Jones');
INSERT INTO address (address_id, line_1, line_2, city, postal_code, district, country_code, type)
        VALUES (DEFAULT, '18 Main St', null, 'Newcomerstown', '43832', 'OH', 'USA', 'HOME');
INSERT INTO contact_address (contact_id, address_id) 
        VALUES ( CURRVAL('contact_contact_id_seq'), CURRVAL('address_address_id_seq') );
INSERT INTO phone ( phone_id, contact_id, phone_number, type, description)
        VALUES ( DEFAULT, CURRVAL('contact_contact_id_seq'), '740-867-5209',  'MOBILE', null);
INSERT INTO email (email_id, contact_id, email_address, type, description) 
        VALUES ( DEFAULT, CURRVAL('contact_contact_id_seq'), 'jenny@tutone.org', 'PERSONAL', null);         
        
  -- INSERT Jimmy Crooked
INSERT INTO contact (contact_id, first_name, last_name)
        VALUES (DEFAULT, 'Jimmy', 'Crooked');
INSERT INTO address (address_id, line_1, line_2, city, postal_code, district, country_code, type)
        VALUES (DEFAULT, '1782 South Ave', null, 'Pittsburgh', '15106', 'PA', 'USA', 'WORK');
INSERT INTO contact_address (contact_id, address_id) 
        VALUES ( CURRVAL('contact_contact_id_seq'), CURRVAL('address_address_id_seq') );
INSERT INTO phone ( phone_id, contact_id, phone_number, type, description)
        VALUES ( DEFAULT, CURRVAL('contact_contact_id_seq'), '412-555-9632', 'WORK', null);
INSERT INTO email (email_id, contact_id, email_address, type, description) 
        VALUES ( DEFAULT, CURRVAL('contact_contact_id_seq'), 'jimmycrooked@cobras.com', 'PERSONAL', null);   
        
 -- INSERT Jung Choi
INSERT INTO contact (contact_id, first_name, last_name)
        VALUES (DEFAULT, 'Jung', 'Choi');
INSERT INTO address (address_id, line_1, line_2, city, postal_code, district, country_code, type)
        VALUES (DEFAULT, '85-1 Chebu-dong', null, 'Seoul', '100-093', 'Jongro-gu', 'KOR', 'WORK');
INSERT INTO contact_address (contact_id, address_id) 
        VALUES ( CURRVAL('contact_contact_id_seq'), CURRVAL('address_address_id_seq') );
INSERT INTO phone ( phone_id, contact_id, phone_number, type, description)
        VALUES ( DEFAULT, CURRVAL('contact_contact_id_seq'), '+82-2-312-3456', 'WORK', null);
INSERT INTO email (email_id, contact_id, email_address, type, description) 
        VALUES ( DEFAULT, CURRVAL('contact_contact_id_seq'), 'jung.choi@gmailing.com', 'WORK', null);
INSERT INTO email (email_id, contact_id, email_address, type, description) 
        VALUES ( DEFAULT, CURRVAL('contact_contact_id_seq'), 'jung.choi@1123.org', 'OTHER', 'Teletext'); 