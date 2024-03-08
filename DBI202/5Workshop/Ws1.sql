create database QLDiem
use QLDiem

create table Class(
	ClassCode varchar(10) primary key not null,
	HeadTeacher varchar(30) not null,
	Room varchar(30) not null,
	TimeSlot varchar(30) not null,
	CloseDate datetime not null
)

create table Student(
	RollNo varchar(10) primary key not null,
	ClassCode varchar(10) foreign key references Class(ClassCode),
	FullName varchar(30) not null,
	Male bit not null,
	BirtDate datetime not null,
	[Address] varchar(30) not null,
	Province char(2) not null,
	Email varchar(30) not null,
)

create table Subject(
	SubjectCode varchar(10) primary key not null,
	SubjectName varchar(40) not null,
	WTest bit not null,
	Ptest bit not null,
	WTest_per smallint not null,
	Ptest_per int not null
)

create table Mark(
	RollNo varchar(10) foreign key references Student(RollNo) not null,
	SubjectCode varchar(10) foreign key references Subject(SubjectCode) not null,
	WMark float not null,
	PMark float not null,
	Mark float not null,
	primary key(RollNo, SubjectCode)

)










