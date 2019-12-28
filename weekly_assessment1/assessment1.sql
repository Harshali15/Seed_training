create table patients
(
patient_id number(2),
patient_name varchar(10) NOT NULL,
email varchar(10) UNIQUE,
registered_date date,
primary key(patient_id)
);

describe patients;

insert into patients values(1,'Harshali','harry',sysdate);
insert into patients values(2,'Vaibhav','chotuu','10-JAN-2017');
insert into patients values(3,'Tanu','tanu',sysdate);
insert into patients values(4,'Priyanka','prii','09-APR-2015');
insert into patients values(5,'Ria','prii',sysdate);---violates the unique email constraint
select * from patients

create table medicines
(
med_id number(2),
med_name varchar(10) NOT NULL,
primary key(med_id)
);

describe medicines;

insert into medicines values(1,'Zocon');
insert into medicines values(2,'Migranin');
insert into medicines values(3,'Disprin');
insert into medicines values(4,'Crosine');
insert into medicines values(5,'Nimdex');

select * from medicines;

create table prescriptions
(
pres_id number(2),
pres_date date,
patient_id number(2),
foreign key(patient_id) references patients(patient_id),
primary key(pres_id)

);
describe prescriptions;

insert into prescriptions values(11,sysdate,1);
insert into prescriptions values(12,'10-JAN-2017',2);
insert into prescriptions values(13,sysdate,3);
insert into prescriptions values(14,'9-APR-2015',4);

select * from prescriptions;

create table patient_meds
(
id number(2),--self evident as uniques as it is pk
presId number(2),
medId number(2),
foreign key(presId) references prescriptions(pres_id), 
foreign key(medId) references medicines(med_id),
primary key (id)
);

insert into patient_meds values(1,11,1);
insert into patient_meds values(2,11,2);
insert into patient_meds values(3,11,4);
insert into patient_meds values(4,12,5);
insert into patient_meds values(5,13,1);
insert into patient_meds values(6,13,4);
insert into patient_meds values(7,14,2);

describe patient_meds;
select * from patient_meds

select * from patients 
where registered_date between '2-APR-2014' and '2-APR-2019'

----Query 1
select * from patients 
where registered_date between '2-APR-2014' and sysdate

----Query 2
select p.pres_id,m.med_id,m.med_name
from prescriptions p join patient_meds pm 
on p.pres_id=pm.presId
join medicines m
on pm.medId=m.med_id
where p.patient_id=1;


