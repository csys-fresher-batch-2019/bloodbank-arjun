drop table donor_details;

drop table donor_id_seq;

create table donor_details(
id number,
name varchar2(30) not null,
gender varchar2(8) not null,
age number not null,
email varchar2(30) UNIQUE not null,
bg_id number not null,
active number default 1,
city varchar2(30),
mobile_number number unique not null,
password varchar2(20)not null,
constraint age_che check(age>=18),
constraint gender_che check(gender in('M','F')),
constraint fk_blood foreign key(bg_id) references blood_group(id),
constraint user_id_pk primary key(id)
);

create sequence donor_id_seq start with 1 increment by 1;

insert into donor_details(id,name,gender,age,email,bg_id,city,mobile_number,password)
values(donor_id_seq.nextval,'ARJUN','M',18,'arjunae798@gmail.com',1,'Madurai',9090909090,'arjun');

insert into donor_details(id,name,gender,age,email,bg_id,city,mobile_number,password)
values(donor_id_seq.nextval,'KESAVAN','M',21,'kesavanp555@gmail.com',3,'Coimbatore',8080808080,'kesavan');

insert into donor_details(id,name,gender,age,email,bg_id,city,mobile_number,password)
values(donor_id_seq.nextval,'KARTHICK','M',20,'karrthicks10@gmail.com',5,'Chennai',7070707070,'karthick');

commit;

select * from donor_details;
