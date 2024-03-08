create database task2
go
use task2

create table customer(cusID varchar(30) primary key, ten nvarchar(100),
diaChi nvarchar(100))
insert into customer(cusID, ten, diaChi) values('www', 'www', 'www')

create table loaiMatHang(maLoai varchar(30) primary key, [type] nvarchar(30)not null)
insert into loaiMatHang(maLoai, type) values('wwwwww', 'wwwwww')

create table matHang(maHang varchar(30) primary key, tinhTrang nvarchar(30) not null, 
moTa nvarchar(100), gia money not null)
insert into matHang(maHang, tinhTrang, moTa, gia) values('wwww', 'wwww', 'wwww', 2000)

create table mua(tinhTrang nvarchar(100), giaMua money not null, ngayMua date  not null,
cusID varchar(30) foreign key references customer(cusID),
maHang varchar(30) foreign key references matHang(maHang),
primary key(cusID, maHang))
insert into mua(tinhTrang, giaMua, ngayMua, cusID, maHang) values ('wwwww', 2000, GETDATE(), 'wwww', 'wwww')

create table ban(giaBan money not null, tienHoaHong money not null, ngayBan date not null,
thue money not null,
cusID varchar(30) foreign key references customer(cusID),
maHang varchar(30) foreign key references matHang(maHang),
primary key(cusID, maHang))
insert into ban(giaBan, tienHoaHong, ngayBan, thue, cusID, maHang) values(2000, 2000,GETDATE(), 2000, 'wwwww','qqqq')

create table thuoc(maHang varchar(30) foreign key references matHang(maHang),
maLoai varchar(30) foreign key references loaiMatHang(maLoai),
primary key (maHang, maLoai))
insert into thuoc(maHang, maLoai) values('wwwwww', 'wwwww')