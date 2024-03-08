/*
chuyen tu ERD--> database
1. entity--> table, key entity -->key table
2. relationship
  *1-1: Khong chuyen khoa vi quan he tren hai khoa chinh cua hai bang
  *1-n: Chuyen khoa chinh cua entity(table) ben 1 sang lam khoa ngoai entity(table) ben nhieu
  *n-m: Tach quan he thanh: 1-n
    -quan he --> table
	  + cac thuoc tinh( bao gom khoa ) thanh thuoc tinh cua newtable
	  + lay khoa chinh cua 2 bang(n,m)(+ khoa chinh cua quan he neu co)
	    --> khoa chinh cua newtable
	  + newTable: khoa chinh gom nhieu thuoc tinh, moi thanh phan cua khoa chinh lai thanh khoa ngoai
--demo task 4
*/
create database task4
go
use task4
--tao ben 1 truoc
create table MonHoc(maMH varchar(30) primary key, tenMH nvarchar(100) not null)
go
create table HocKy(maHK varchar(30) primary key, tenKH nvarchar(100) not null)
go
create table Khoa(maKhoa varchar(30) primary key, temKhoa nvarchar(100) not null)
--ben nhieu
create table MonHocMo (maMonMo varchar(30) primary key, maMH varchar(30) foreign key references MonHoc(maMH),maHK varchar(30) foreign key references HocKy(maHK))
--
create table SinhVien(maSV varchar(30) primary key, tenSV nvarchar(30) not null, maKhoa varchar(30) foreign  key references Khoa(maKhoa))
--quan he nhieu nhieu
create table Diem(diemKT float, diemTK float, diemThi float check(diemThi>=0 And diemThi<=10), maMonMo varchar(30) foreign key references MonHocMo(maMonMo), maSV varchar(30) foreign key references SinhVien(maSV), primary key(maMonMo,maSV))
