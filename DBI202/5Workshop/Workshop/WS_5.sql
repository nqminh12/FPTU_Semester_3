create database QLDiemSV
use QLDiemSV
-----
create table Khoa(maKhoa varchar(5) primary key, tenKhoa varchar(10), soCBGD varchar(10))

insert into Khoa values ('VH01', 'Van Hoa', '001')
insert into Khoa values ('KT01', 'Kinh Te', '0012')
insert into Khoa values ('KS06', 'Khach San', '00443')
insert into Khoa values ('PM09', 'Phan Mem', '00139')
select *from Khoa
-----
create table Lop(maLop varchar(10) primary key, tenLop varchar(5), 
maKhoa varchar(5) foreign key references Khoa(maKhoa))

insert into Lop values ('D111', 'TCSK', 'VH01')
insert into Lop values ('D202', 'QTKD', 'KT01')
insert into Lop values ('B123', 'QTKS', 'KS06')
insert into Lop values ('D217', 'SQL', 'PM09')
select * from Lop
-----
create table SinhVien(maSV varchar(10) primary key, hoTen varchar(30), gioiTinh bit, 
ngaySinh date, maLop varchar(10) foreign key references Lop(maLop),
hocBong int, Tinh varchar(15)) 

insert into SinhVien values ('S01', 'Nguyen Thi Thuy', '0', '12/09/2000', 'D111', '100000', 'Ha Noi')
insert into SinhVien values ('S02', 'Luong Thuy Hoa', '0', '06/30/2003', 'B123', '80000', 'Thai Binh')
insert into SinhVien values ('S03', 'Hoang Chau', '1', '11/21/2003', 'D217', '50000', 'Lang Son')
insert into SinhVien values ('S04', 'Nguyen Viet Hoang', '1', '02/09/2001', 'D202', '100000', 'Vinh')
insert into SinhVien values ('S05', 'Tran Dung', '1', '05/21/2000', 'D217', '120000', 'Ha Noi')
insert into SinhVien values ('S06', 'Hoang Linh', '0', '04/21/2001', 'D111', '500000', 'Hung Yen')
select * from SinhVien
-----
update SinhVien set ngaySinh='04/21/2001', hoTen='Eng Juy' where maSV='S06'
update SinhVien set hocBong=hocBong+100000 where maSV='S03'
select * from SinhVien
-----
delete SinhVien where maSV='S07'
select * from SinhVien
