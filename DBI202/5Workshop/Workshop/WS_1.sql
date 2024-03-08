create database QLDiem
use QLDiem

create table Class(classCode varchar(10) primary key, headTeacher varchar(30),
room varchar(30), timeSlot varchar(30), closeDate datetime)

create table Student(rollNo varchar(10) primary key, 
classCode varchar(10) foreign key references Class(classCode),
fullName varchar(30), male bit, birthDate datetime, 
address varchar(30), province char(2), 
email varchar(30))

create table Subject(subjectCode varchar(10) primary key, subjectName varchar(40),
wTest bit, pTest bit, WTest_per smallint, pTest_per int)

create table Mark(subjectCode varchar(10)foreign key references Subject(subjectCode),
rollNo varchar(10) foreign key references Student(rollNo),
primary key(rollNo, subjectCode), 
wMark float(8), pMark float(8),
mark float(8))

-- insert Class
insert into Class values ('E123', 'QuangMinh', 'class2, lab1', '7h30-12h30', getDate())
insert into Class values ('E125', 'NguyenMinh', 'class2, lab1', '7h30-12h30', getDate())
select * from Class

-- insert Subject
insert into Subject values ('C', 'Programming with C', '1', '1', '40', '60')
insert into Subject values ('SQL1', 'SQL1', '1', '0', '100', '0')
insert into Subject values ('SQL2', 'SQL2', '1', '1', '40', '60')
select * from Subject

-- insert Student
insert into Student(rollNo, classCode, fullName, male, birthDate, address, province) 
values ('A01', 'E123', 'Nguyen A', '1', '11/23/1982', '65 Hoang Hoa Tham', 'HN')
insert into Student(rollNo, classCode, fullName, male, birthDate, province, email)
values ('A02', 'E123', 'Nguyen B', '1', '10/21/1982', 'HN', 'trongfpt.edu.vn')
insert into Student(rollNo, classCode, fullName, male, birthDate, address, province, email)
values ('A03', 'E123', 'Nguyen C', '1', '10/19/1983', '6 Tran Phu', 'HN', 'dung@fpt.edu.vn')
insert into Student(rollNo, classCode, fullName, male, birthDate, address, province)
values ('A04', 'E123', 'Nguyen D', '1', '11/10/1984', '3 Kim Ma', 'HN')
insert into Student(rollNo, classCode, fullName, male, birthDate, province)
values ('A05', 'E123', 'Nguyen E', '1', '9/11/1983', 'HP')
insert into Student(rollNo, classCode, fullName, male, birthDate, address, province)
values ('A06', 'E123', 'Nguyen Y', '0', '10/26/1986', '65 Hoang Hoa Tham', 'HN')
select * from Student

--ínsert Mark
insert into Mark values ('C','A01', '20', '10', '14')
insert into Mark values ('SQL1','A01',  '20', '0', '8')
insert into Mark values ('SQL2','A01', '18', '12', '18.2')
insert into Mark values ('C','A02', '20', '10', '14')
insert into Mark values ('SQL1','A02',  '23', '15', '14')
insert into Mark values ('SQL2','A02',  '23', '10', '18')
select * from Mark

--update class
update Class set headTeacher='NguyenMinh' where headTeacher='NguyenMinh'
select * from Class

--delete Student
delete Student where rollNo='A06'
select * from Student


