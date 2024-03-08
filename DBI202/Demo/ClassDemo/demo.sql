--creat database dbName 
create database SE1762

-- xoa DB
drop database SE1762
-- open database: use databaseName
use SE1762
-- create table
/*
	Create table tableName(fieldName dataType[(size)] [constrains],...)
	dataType: 
	int: 4 byte
	float: 8 byte
	real: 4 byte
	money: 8 byte
	small money: 4 byte
	bit: true | false (1,0)
	char(maxsize): khong unicode, do dai co dinh maxsize
	varchar(30): khong unicode, do dai toi da maxsize
	nvarchar(maxsize): unicode, do dai toi da maxsize(note: bo nho maxSize * 2) 
	date: ngayf thangs(long date)
	smallDate: ngày tháng
	dateTime: date+time
*/
-- nếu cái tên trườn dổi màu xanh --> trùng từ khóa--> để an toàn có thể khai báo trong ngoặc vuông
-- trong cặp []
-- tên trường bắt buộc có dấu cách--> phải viết trong[]: [full name]
create table Products(pid varchar(30), pname nvarchar(100), createDate date,
quantity int, price money , [description] nvarchar(max),[status] bit)
go
drop table Products
go 
--primary key, constains
--not null: requier input
--check: input condition
--getDate(): return current date
--default: khong input thi dungf default
create table Products(pid varchar(30) primary key, pname nvarchar(100) not null,
createDate date check(createDate >= getdate()) default getDate(),quantity int check(quantity >= 0),
price money check(price >= 0), [description] nvarchar(max),[status] bit default 1)

--Customer
--identity(1,1): start 1, step 1
--unique(unique key): dung dinh nghĩa các trường có giá trị duy nhất nhưng không phải khóa chính
--khoa chính
create table Customer(cusID int primary key identity(1,1), 
cName nvarchar(30) not null, userName varchar(100) unique,
password varchar(32) check(len(password) >= 8))
go 
drop table Customer
go
---Khóa Ngoại(foreign key)
--Customer (1) --<Have>--(n) -- Bill: cusID cua Customer chuyen sang 
-- Bill lamf foreign key
-- foreign key cùng kiển và độ lớn với primary key
create table Bill(billID varchar(100) primary key, dateCreate dateTime default getdate(),
totalBill money, cusID int foreign key references Customer(cusID))
--multi primary key
-- Bill --(1)--<have>--(n)--BillDate--(n)--<have>--(1)--Product
-- BillDetail: hai truong lam khoa chinh pid, billID
--maBill: foreign key, billID primary key of Bill
create table BillDetail(
maBill varchar(100) foreign key references Bill(billID),
pid varchar(30) foreign key references Products(pid),
quantity int, price money, subtotal money, primary key(maBill, pid))





