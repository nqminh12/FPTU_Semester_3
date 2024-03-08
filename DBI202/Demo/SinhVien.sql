/*
Chuyển từ ERD --> database
1. entity --> table, key entity --> key table
2. relationship
	*1-1: không chuyển khóa vì quan hệ trên hai khóa chính của 2 bảng
	*1-n: chueyenr kháo chính của entity(table) bên 1 sang làm khóa ngoại
		entity(table) bên nhiều
	*n-m: tách quan hệ thành 2: 1-n
		- quan hệ --> table
			+ các thuộc tính(bao gồm khóa) thành thuộc tính của newtable
			+ lấy khóa chính của hai bảng (n,m) (+khóa chính của quan hệ nếu có)
				--> tạo thành khóa chính của newTable
			+ new table: khóa chính gồm nhiều thuộc tính, nhưng mỗi thành phần của khóa chính
			lại là khóa ngoại
*/
-- demo task 4:
create database task4
use task4
-- tao ben 1 truoc
create table MonHoc(maMH varchar(30) primary key, temMH nvarchar(100) not null)
go
create table HocKi(maHK varchar(20) primary key, tenHK nvarchar(100) not null)
go
create table Khoa(maKhoa varchar(30) primary key, tenKhoa nvarchar(100) not null)

-- ben nhieu
create table MonHocMo(maMonMo varchar(30) primary key, 
maMH varchar(30) foreign key references MonHoc(maMH),
maHK varchar(20) foreign key references HocKi(maHK))
--sinh vien
create table SinhVien(maSV varchar(30) primary key, tenSV nvarchar(30) not null,
maKhoa varchar(30) foreign key references Khoa(maKhoa))
--quan he nhieu nhieu n - m
create table Diem(diemKT float, diemThi Float check(diemThi >= 0 And diemThi <= 10), 
maMonMo varchar(30) foreign key references MonHocMo(maMonMo),
maSV varchar(30) foreign key references SinhVien(maSV),
primary key(maMonMo, maSV))
