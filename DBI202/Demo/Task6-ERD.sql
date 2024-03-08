create database task6

use task6
go

create table Doctors(
	dID nvarchar(30) primary key not null,
	dName varchar(30) not null,
	dExpertise nvarchar(30) not null
)
insert into Doctors(dID, dName, dExpertise) values(1, 'wwwwww', 'wwwwww')
insert into Doctors(dID, dName, dExpertise) values(2, 'wwwwww', 'wwwwww')
select * from Doctors
go

create table Patients(
	pID nvarchar(30) primary key not null,
	pName varchar(30),
	dID nvarchar(30) foreign key references Doctors(dID)
)
insert into Patients(pID, pName) values(1, 'wwwww')
insert into Patients(pID, pName) values(2, 'wwwww')
select * from Patients

go

create table Treatment(
	dID nvarchar(30) foreign key references Doctors(dID),
	pID nvarchar(30) foreign key references Patients(pID),	
	tDay date,
	tResult nvarchar(30),
	primary key(dID, pID)
)

insert into Treatment(dID, pID, tDay, tResult) values(1,1,GETDATE(), 'wwwww')
insert into Treatment(dID, pID, tDay, tResult) values(2,2,GETDATE(), 'wwwww')
select * from Treatment
