create database task3

use task3
go

create table Subjects(
	sID nvarchar(10) primary key not null,
	sName varchar(10),
	sCredit varchar(2)
)

insert into Subjects(sID, sName, sCredit) values('DBI201', 'dulieu', '3')
select * from Subjects

create table Courses(
	cID nvarchar(10) primary key not null,
	cSemester int,
	cYear int
)

insert into Courses (cID, cSemester, cYear) values('1123', 4, 2023)
select * from Courses

create table Prerequisite(
	pID nvarchar(10) primary key,
	sID nvarchar(10) foreign key references Subjects(sID)
)


insert into Prerequisite(pID, sID) values ('1123', 'DBI201')
select * from Courses
select * from Prerequisite