create sequence hibernate_sequence start 1 increment 1;

create sequence employee_id_seq;
create table employee (
    employee_id int8 not null DEFAULT nextval('employee_id_seq'),
    first_name varchar(255),
    last_name varchar(255),
    department_id int8,
    job_title varchar(255),
	  gender varchar(255),
    primary key (employee_id)
);
