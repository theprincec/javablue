--create database project_organizer;

select * from employee;

--create database animal_hospital;
drop table if exists employee_project;
--drop table if exists employee;



create table employee_project(
        employee_number int,
        project_number int,
        
        PRIMARY KEY (employee_number, project_number),
        CONSTRAINT fk_employee_employee_number FOREIGN KEY (employee_number) REFERENCES employee(employee_number),
        CONSTRAINT fk_project_project_number FOREIGN KEY (project_number) REFERENCES project(project_number)      

);

create table employee(
        pet_id serial primary key,
        owner_id int,
        name varchar(20) not null,
        type varchar (20),
        age int not null,

        CONSTRAINT fk_pet_owner_id FOREIGN KEY (owner_id) REFERENCES owner(owner_id),
        CONSTRAINT Chk_type CHECK (type in ('Dog', 'Cat', 'Bird', 'Turtle', 'Zebra', 'Hippopotamus', 'Salmon', 'Gerbil')

);


select * from employee_project;




--create database animal_hospital;
drop table if exists pet;
drop table if exists owner;
drop table if exists visit;
drop table if exists procedure;
drop table if exists invoice;



create table pet(
        pet_id serial primary key,
        owner_id int,
        name varchar(20) not null,
        type varchar (20),
        age int not null,

        CONSTRAINT fk_pet_owner_id FOREIGN KEY (owner_id) REFERENCES owner(owner_id),
        CONSTRAINT Chk_type CHECK (type in ('Dog', 'Cat', 'Bird', 'Turtle', 'Zebra', 'Hippopotamus', 'Salmon', 'Gerbil')

);


create table owner(
        owner_id serial primary key,
        first_name varchar(20) not null,
        last_name varchar(20) not null,
        address varchar(255) not null,
        city varchar(48) not null,
        district varchar(48) not null,
        postal_code varchar(10) not null

);

create table visit(
        visit_id serial primary key,
        pet_id int,
        date DATE,
        
        CONSTRAINT fk_visit_pet_id FOREIGN KEY (pet_id) REFERENCES pet(pet_id)
        
);

create table procedure(
        procedure_id serial primary key,
        type varchar(48)


);

create table visit_procedure(
        procedure_id int,
        visit_id int,
        
        PRIMARY KEY (procedure_id, visit_id),
        CONSTRAINT fk_procedure_procedure_id FOREIGN KEY (procedure_id) REFERENCES procedure(procedure_id),
        CONSTRAINT fk_visit_visit_id FOREIGN KEY (visit_id) REFERENCES visit(visit_id)      

);

create table invoice(
        invoice_id serial primary key,
        visit_id int,
        total_cost decimal(7,2),
        
        CONSTRAINT fk_invoice_visit_id FOREIGN KEY (visit_id) REFERENCES visit(visit_id)


);
