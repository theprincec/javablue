select * from contact;

SELECT contact_id, first_name, last_name FROM contact;


UPDATE contact SET contact_id = 0, first_name = '', last_name = '' WHERE contact_id = <condition>;

INSERT INTO contact (contact_id, first_name, last_name) VALUES (DEFAULT, ?, ?);
