create database task5_b
use task5_b
create table TuyenBay(
maTB varchar(50) primary key,
tenTPxp nvarchar(30),
tenTPden nvarchar(30),
dgVe money,
gioBay varchar(10)
)
insert into TuyenBay(maTB, tenTPxp, tenTPden, dgVe, gioBay) values('wwwwww','wwwwww','wwwwww',2000,'wwwwww')

create table DonViBay(
maDV varchar(50) primary key,
tenDV nvarchar(30)
)
insert into DonViBay(maDV, tenDV) values('wwwwww', 'wwwwwww')

create table PhiCong(
maPC varchar(50) primary key,
maDV varchar(50) foreign key references DonViBay(maDV),
tenPC nvarchar(30),
phaiPC nvarchar(30),
ngayS date

)

insert into PhiCong(maPC, maDV, tenPC, phaiPC, ngayS) values('wwwwww', 'wwwwww', 'wwwwww', 'wwwwww', GETDATE())
create table ChuyenBay(
maCB varchar(50) primary key,
maTB varchar(50) foreign key references TuyenBay(maTB),
loaiMB nvarchar(50)
)

insert into ChuyenBay(maCB, loaiMB) values('wwwwww','wwwwww')
create table HanhKhach(
maHK varchar(50) primary key,
tenHK nvarchar(30),
phaiHK nvarchar(30),
ngayS date
)
insert into HanhKhach(maHK,tenHK, phaiHK, ngayS) values('wwwwww','wwwwww','wwwwww',GETDATE())
create table VeMayBay(
maVe varchar(50) primary key,
maHK varchar(50) foreign key references HanhKhach(maHK),
maCB varchar(50) foreign key references ChuyenBay(maCB)

)
insert into HanhKhach(maHK) values('asasas')
create table DieuKien(
maCB varchar(50) foreign key references ChuyenBay(maCB),
maPC varchar(50) foreign key references PhiCong(maPC),
primary key(maCB,maPc)
)

insert into DieuKien(maCB, maPC) values('wwwwww', 'wwwwww')
