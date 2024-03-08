create database task7

use task7

create table Branches(
	bName nvarchar(10) primary key not null,
	bLocation varchar(30),
)
insert into Branches(bName, bLocation) values('wwwwww', 'wwwwww')
insert into Branches(bName,bLocation) values('aaaaaa', 'aaaaa')
go

create table Customers(
	cID nvarchar(10) primary key not null,
	cFullName varchar(20) not null,
	cPhone varchar(12),
	cAddress varchar(30)
)
insert into Customers(cID, cFullName, cPhone, cAddress) values('wwwwww', 'wwwwww', 'wwwwww', 'wwwwwww')
insert into Customers(cID, cFullName, cPhone, cAddress) values('aaaaaa', 'wwwwww', 'wwwwww', 'wwwwwww')
go

create table PowerStation(
	pName nvarchar(10) not null,
	bName nvarchar(10) foreign key references Branches(bName)
) 
insert into PowerStation(pName, bName) values('bbbbbb', 'wwwwww')
insert into PowerStation(pName, bName) values('aaaaaa', 'aaaaaa')
select * from PowerStation

go

create table Electrometer(
	eNumber nvarchar(10) primary key not null,
	eIndex varchar(10),
	bName nvarchar(10) foreign key references Branches(bName),
	cID nvarchar(10) foreign key references Customers(cID),
)
insert into Electrometer(eNumber, eIndex, bName,cID) values('wwwwww', 'wwwwww', 'wwwwww','wwwwww')
insert into Electrometer(eNumber, eIndex, bName,cID) values('aaaaaa', 'aaaaaa', 'aaaaaa','aaaaaa')

go

create table ElectricRecord(
	electricNumber nvarchar(10) primary key not null,
	electricName nvarchar(10) not null,
	electricDate date,
	electricIndex varchar(10),
	eNumber nvarchar(10) foreign key references Electrometer(eNumber)
)
insert into ElectricRecord(electricNumber, electricName, electricDate, electricIndex, eNumber) values('wwwwww', 'wwwwww', getDate(),
'wwwwww', 'wwwwww')
insert into ElectricRecord(electricNumber, electricName, electricDate, electricIndex, eNumber) values('aaaaaa','aaaaaa',GETDATE(),
'aaaaaa', 'aaaaaa')