Create Database QuanLyDiemSV
use QuanLyDiemSV
-----
Create table DMKhoa(MaKhoa char(2) primary key,
TenKhoa nvarchar(30) not null)

Insert into DMKhoa(MaKhoa,TenKhoa) values('AV',N'Anh Văn')
Insert into DMKhoa(MaKhoa,TenKhoa) values('TH',N'Tin Học')
Insert into DMKhoa(MaKhoa,TenKhoa) values('TR',N'Triết')
Insert into DMKhoa(MaKhoa,TenKhoa) values('VL',N'Vật Lý')
SELECT * FROM DMKhoa
-----
Create table DMSV(MaSV char(3) not null primary key,HoSV nvarchar(15) not null,
TenSV nvarchar(7) not null,Phai nchar(7),NgaySinh datetime not null,
NoiSinh nvarchar(20),MaKhoa char(2), HocBong float)

SET DATEFORMAT DMY
GO
Insert into DMSV values('A01',N'Nguyễn Thị',N'Hải',N'Nữ','23/02/1990',N'Hà Nội','TH',130000)
Insert into DMSV(MaSV,HoSV,TenSV,Phai,NgaySinh,NoiSinh,MaKhoa,HocBong) values('A02',N'Trần Văn',N'Chính',N'Nam','24/12/1992',N'Bình Định','VL',150000)
Insert into DMSV(MaSV,HoSV,TenSV,Phai,NgaySinh,NoiSinh,MaKhoa,HocBong) values('A03',N'Lê Thu Bạch',N'Yến',N'Nữ','21/02/1990',N'TP Hồ Chí Minh','TH',170000)
Insert into DMSV(MaSV,HoSV,TenSV,Phai,NgaySinh,NoiSinh,MaKhoa,HocBong) values('A04',N'Trần Anh',N'Tuấn',N'Nam','20/12/1990',N'Hà Nội','AV',80000)
Insert into DMSV(MaSV,HoSV,TenSV,Phai,NgaySinh,NoiSinh,MaKhoa,HocBong)  values('B01',N'Trần Thanh',N'Mai',N'Nữ','12/08/1991',N'Hải Phòng','TR',0)
Insert into DMSV(MaSV,HoSV,TenSV,Phai,NgaySinh,NoiSinh,MaKhoa,HocBong) values('B02',N'Trần Thị Thu',N'Thủy',N'Nữ','02/01/1991',N'TP Hồ Chí Minh','AV',0)
SELECT * FROM DMSV
-----
create table DMMH(MaMH char(2) not null,TenMH nvarchar(25) not null,SoTiet tinyint
Constraint DMMH_MaMH_pk primary key(MaMH))

Insert into DMMH(MaMH,TenMH,SoTiet) values('01',N'Cơ Sở Dữ Liệu',45)
Insert into DMMH(MaMH,TenMH,SoTiet) values('02',N'Trí Tuệ Nhân Tạo',45)
Insert into DMMH(MaMH,TenMH,SoTiet) values('03',N'Truyền Tin',45)
Insert into DMMH(MaMH,TenMH,SoTiet) values('04',N'Đồ Họa',60)
Insert into DMMH(MaMH,TenMH,SoTiet) values('05',N'Văn Phạm',60)
select * from DMMH
-----
Create table KetQua(MaSV char(3) not null,MaMH char(2) not null,LanThi tinyint,
Diem decimal(4,2), Constraint KetQua_MaSV_MaMH_LanThi_pk 
primary key(MaSV,MaMH,LanThi))

Insert into KetQua(MaSV,MaMH,LanThi,Diem) values('A01','01',1,3)
Insert into KetQua(MaSV,MaMH,LanThi,Diem) values('A01','01',2,6)
Insert into KetQua(MaSV,MaMH,LanThi,Diem) values('A01','02',2,6)
Insert into KetQua(MaSV,MaMH,LanThi,Diem) values('A01','03',1,5)
Insert into KetQua(MaSV,MaMH,LanThi,Diem) values('A02','01',1,4.5)
Insert into KetQua(MaSV,MaMH,LanThi,Diem) values('A02','01',2,7)
Insert into KetQua(MaSV,MaMH,LanThi,Diem) values('A02','03',1,10)
Insert into KetQua(MaSV,MaMH,LanThi,Diem) values('A02','05',1,9)
Insert into KetQua(MaSV,MaMH,LanThi,Diem) values('A03','01',1,2)
Insert into KetQua(MaSV,MaMH,LanThi,Diem) values('A03','01',2,5)
Insert into KetQua(MaSV,MaMH,LanThi,Diem) values('A03','03',1,2.5)
Insert into KetQua(MaSV,MaMH,LanThi,Diem) values('A03','03',2,4)
Insert into KetQua(MaSV,MaMH,LanThi,Diem) values('A04','05',2,10)
Insert into KetQua(MaSV,MaMH,LanThi,Diem) values('B01','01',1,7)
Insert into KetQua(MaSV,MaMH,LanThi,Diem) values('B01','03',1,2.5)
Insert into KetQua(MaSV,MaMH,LanThi,Diem) values('B01','03',2,5)
Insert into KetQua(MaSV,MaMH,LanThi,Diem) values('B02','02',1,6)
Insert into KetQua(MaSV,MaMH,LanThi,Diem) values('B02','04',1,10)
select *from KetQua
-----
Alter table dmsv add Constraint DMKhoa_MaKhoa_fk foreign key(MaKhoa) References DMKhoa(MaKhoa)
Alter table KetQua add constraint KetQua_MaSV_fk foreign key(MaSV) references DMSV(MaSV),
constraint DMMH_MaMH_fk foreign key(MaMH)references DMMH(MaMH)
-----
update DMMH set SoTiet='45' where MaMH='05'
select * from DMMH
update DMSV set NgaySinh='05/07/1990' where MaSV='b02'
select * from DMSV
update DMSV set TenSV=N'Kỳ', Phai='Nam' where MaSV='b01'
select * from DMSV
update DMSV set HocBong=HocBong+100000 where MaKhoa='Av'
select * from DMSV
-----
delete DMSV where MaKhoa='TL'
select * from DMSV