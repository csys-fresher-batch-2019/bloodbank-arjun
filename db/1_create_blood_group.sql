drop table blood_group;

create table blood_group(
id number,
name varchar2(20),
constraint bgid_pk primary key(id)
);

insert into blood_group(id,name)
values(1,'A+ve');

insert into blood_group(id,name)
values(2,'A-ve');

insert into blood_group(id,name)
values(3,'B+ve');

insert into blood_group(id,name)
values(4,'B-ve');

insert into blood_group(id,name)
values(5,'O+ve');

insert into blood_group(id,name)
values(6,'O-ve');

insert into blood_group(id,name)
values(7,'AB+ve');

insert into blood_group(id,name)
values(8,'AB-ve');

insert into blood_group(id,name)
values(9,'Golden Blood');

commit;

select * from blood_group;