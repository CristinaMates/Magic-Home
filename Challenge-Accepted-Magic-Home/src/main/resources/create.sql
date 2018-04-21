--create sequence seq_number;
drop table patient;
CREATE TABLE public.patient
(
  first_name character varying(50),
  last_name character varying(50),
  disability boolean,
  age numeric(50,0),
  diagnosis character varying(50),
  id numeric NOT NULL default nextval('seq_number'),
  doctor_id numeric,
  CONSTRAINT idprimarykey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);


create table doctor(
	first_name varchar (50),
	last_name varchar (50),
	id numeric NOT NULL default nextval('seq_number')
	);
create table reservation (
	id numeric NOT NULL default nextval('seq_number'),
	custodianID numeric,
	patientID numeric,
	doctorID numeric,
	numberOfCustodians numeric,
	entranceDate date,
	days int,
	needsPsychologicalCounseling boolean
	);

create table custodian (
	first_name varchar (50),
	last_name varchar (50),
	telephone varchar (50),
    id numeric NOT NULL default nextval('seq_number')

	);


	select * from custodian;