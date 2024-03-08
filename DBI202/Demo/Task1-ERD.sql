create database task1
use task1

create table Employees(eID varchar(30) not null primary key, eName nvarchar(30) not null,
address varchar(30), birthday date)
insert into Employees(eID, eName, address, birthday) values(1, 'minh', 'wwwwwwwwwww', getDate())
insert into Employees(eID, eName, address, birthday) values(2, 'Sonnnn', 'wwwwwwwwwww', getDate())
select * from Employees
go
create table Projects(pID varchar(30) not null primary key, pName nvarchar(30) not null, 
dateStart date)
insert into Projects(pID, pName, dateStart) values(1, 'minh', getDate())
insert into Projects(pID, pName, dateStart) values(2, 'minh', getDate())
select * from Projects
go

create table Employee_Projects(eID varchar(30) foreign key references Employees(eID),
pID varchar(30) foreign key references Projects(pID), salary money)
insert into Employee_Projects(salary) values(2000)
insert into Employee_Projects(salary) values(3000)
select * from Employee_Projects


