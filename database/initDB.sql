--Create user for the aplication
CREATE USER opme_app WITH encrypted password 'test@&8' createdb CONNECTION LIMIT 30;

--Create database with user aplication owner to avoid permission problems
CREATE database opmeapi owner opme_app;

--Create schema for tables to add one more layer of security, best pratice in micro services.
CREATE SCHEMA operation AUTHORIZATION opme_app;

--Create tables
create table operation.activities(
id bigserial not null primary key,
title varchar(255) not null,
subtitle varchar(255) not null,
servicelevelagreement int not null
);

insert into operation.activities(title, subtitle, servicelevelagreement) values ('Auditoria','Limpar conta',4);
insert into operation.activities(title, subtitle, servicelevelagreement) values ('Berçario','Organizar prontuário',3);
insert into operation.activities(title, subtitle, servicelevelagreement) values ('Centro Cirurgico','Organizar prontuário',2);
insert into operation.activities(title, subtitle, servicelevelagreement) values ('Comercial','Vender produto',1);

create table operation.patients(
id bigserial not null primary key,
"name" varchar(500) not null
);

create table operation.healthinsurance(
id serial not null primary key,
"name" varchar(500) not null
);

create table operation.bill(
id serial not null primary key,
"type" text not null
);

create table operation.cards(
id bigserial not null primary key,
creationdate timestamp,
slaStatus text not null,
activitie_id int not null,
patient_id bigint not null references operation.patients(id),
healthinsurance_id int not null references operation.healthinsurance(id),
visit_id int not null,
bill_id int not null references operation.bill(id),
totalamount decimal(12,2) not null,
numberofpendencies int not null,
numberofopenpendencies int not null,
numberofdocuments int not null,
numberofnotreceiveddocuments int not null,
numberofchecklistitem int not null,
numberofdonechecklistitem int not null
);