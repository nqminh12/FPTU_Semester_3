create database BANHANG
use BANHANG
-----
create table NhanVien(maNV varchar(10) primary key, hoTen varchar(30), chucDanh varchar(30),
ngaySinh date, ngayNhanViec datetime, diaChi varchar(30), phone varchar(15),
photo varchar(10), ghiChu varchar(30))

insert into NhanVien values('01', 'Lan Huong', 'Ban hang', '11/15/1993','1/13/2005', 'Hoa Binh',
'0361745624','<Binary>', null)
insert into NhanVien values('02', 'Bich Hue', 'Tiep thi', '12/31/1979','1/22/2001', 'Quang Binh',
'0987565223','<Binary>', null)
insert into NhanVien values('03', 'Tung Chi', 'Ban hang', '8/9/1986','1/14/2005', 'Hai Phong',
'0986567134','<Binary>', null)
insert into NhanVien values('04', 'Kien Cuong', 'Thu kho', '1/22/1979','9/19/2003', 'Ha Noi',
'0912341245','<Binary>', null)
select * from NhanVien
-----
create table NhaCungCap(maNhaCC varchar(10) primary key, tenNhaCC varchar(30), diaChi varchar(30),
phone varchar(15), fax varchar(20), homePage varchar(30))

insert into NhaCungCap values('BAN', 'Cong ty Ban Mai', '64 Hang Bun', '048286745', null, 'www.binhminh.com')
insert into NhaCungCap values('OCE', 'Cong ty Ocean', '26 Tran Quy Cap', '048924712', null, 'www.ocean.com')
insert into NhaCungCap values('RDO', 'Cong ty Rang Dong', '97 Hoang Hoa Tha,', '048923711', null, 'www.rdong.com')
select  * from NhaCungCap
-----
create table KhachHang(maKH varchar(20) primary key, tenKH varchar(30), diaChi varchar(30),
phone varchar(15), email varchar(30))

insert into KhachHang values ('01', 'Hoa Binh', 'Ha Noi', '0987455144', 'hb@fpt.vn')
insert into KhachHang values ('02', 'Quang Long', 'Ha Noi', '0945251457', 'qlong@yahoo.vn')
insert into KhachHang values ('03', 'Nguyen Tuan', 'Hai Phong', '0124567256', 'Tuan@Yahoo.vn')
select  * from KhachHang
-----
create table LoaiSanPham(maLoaiSP varchar(10) primary key, tenLoaiSP varchar(15), moTa ntext)

insert into LoaiSanPham values ('DL', 'Dien Lanh', null)
insert into LoaiSanPham values ('DT', 'Dien Tu', null)
insert into LoaiSanPham values ('MP', 'Hang my pham', null)
insert into LoaiSanPham values ('TD', 'Hang tieu dung', null)
select  * from LoaiSanPham
-----
create table HoaDon(maHD varchar(10) primary key, 
maKH varchar(20) foreign key references KhachHang(maKH),
maNV varchar(10) foreign key references NhanVien(maNV),
ngayLapHD smalldatetime, ngayNhanHang smalldatetime,  tien int, thue real, tongSoTien int)

insert into HoaDon values ('05', '02', '01', '3/14/1997', '12/15/2007', '0', '0.05', '0')
insert into HoaDon values ('02', '01', '01', '1/19/2006', '2/15/2006', '0', '0.05', '0')
insert into HoaDon values ('03', '02', '02', '10/30/2006','1/1/2006', '0', '0.1', '0')
select  * from HoaDon
-----
create table SanPham(maSP varchar(10) primary key, tenSP varchar(40),
maNhaCC varchar(10) foreign key references NhaCungCap(maNhaCC),
maLoaiSP varchar(10)foreign key references LoaiSanPham(maLoaiSP),
DVT varchar(20), donGia smallint, soLuong smallint, soLuongTT smallint, Discontinued bit)

insert into SanPham values('001', 'Vo tuyen', 'BAN', 'DT', 'Chiec', '4000', '25', '5', '0')
insert into SanPham values('002', 'Radio', 'BAN', 'DT', 'Chiec', '200', '150', '20', '0')
insert into SanPham values('003', 'CD player', 'BAN', 'DT', 'Chiec', '2000', '45', '10', '0')
insert into SanPham values('004', 'Tu lanh', 'RDO', 'DT', 'Chiec', '6000', '22', '5', '0')
insert into SanPham values('005', 'May lam kem', 'RDO', 'DT', 'Chiec', '7000', '19', '4', '0')
insert into SanPham values('006', 'Dieu hoa', 'RDO', 'DT', 'Chiec', '9000', '38', '7', '0')
insert into SanPham values('008', 'Xa phong thom', 'OCE', 'TD', 'Banh', '6', '200', '50', '0')
insert into SanPham values('009', 'Duong', 'OCE', 'TD', 'kg', '9', '550', '50', '0')
insert into SanPham values('0010', 'Sua', 'OCE', 'TD', 'hop', '120', '80', '20', '0')
select * from SanPham
-----
create table HoaDonChiTiet(maHD varchar(10) foreign key references HoaDon(maHD),
maSP varchar(10) foreign key references SanPham(maSP),
donGia int, soLuong smallint, giamGia real, thanhTien int)

insert into HoaDonChiTiet values('03', '003', '0', '3', '0.02', '0')
insert into HoaDonChiTiet values('03', '006', '0', '2', '0.01', '0')
insert into HoaDonChiTiet values('03', '05', '0', '10', '0', '0')
insert into HoaDonChiTiet values('02', '010', '0', '11', '0.04', '0')
insert into HoaDonChiTiet values('02', '002', '0', '2', '0.01', '0')
insert into HoaDonChiTiet values('01', '004', '0', '1', '0.05', '0')
insert into HoaDonChiTiet values('01', '009', '0', '15', '0.04', '0')
select * from HoaDonChiTiet
-----
select * from NhanVien
select  * from NhaCungCap
select  * from KhachHang
select  * from LoaiSanPham
select  * from HoaDon
select * from SanPham
select * from HoaDonChiTiet

-----
update HoaDonChiTiet set donGia='3'
select * from HoaDonChiTiet

update HoaDonChiTiet set donGia='4' where maHD='01'
select * from HoaDonChiTiet
-----
delete HoaDonChiTiet where maSP='004'
select * from HoaDonChiTiet

-- cau 1
update HoaDonChiTiet
set thanhTien = donGia* soLuong * (1-giamGia)
select * from HoaDonChiTiet

-- cau 2
update HoaDon
set tongSoTien = (
	select sum(thanhTien) from HoaDonChiTiet
	where HoaDonChiTiet.maHD = HoaDon.maHD)
update HoaDon
set tongSoTien = Tien * (thue + 1)

-- cau 3
select b.maLoaiSP, a. maSP, a.tenSP 
from SanPham as a join LoaiSanPham as b on a.maLoaiSP = b.maLoaiSP
order by a.tenSP asc

select a.maLoaiSP, a. maSP, a.tenSP 
from SanPham as a 
order by a.tenSP asc



-- cau 4
select b.maSP, b.tenSP, count(*) as totalSold
from HoaDonChiTiet as a join SanPham as b on a.maSP = b.maSP
group by b.maSP, b.tenSP


-- cau 5
select a.maSP, b.tenSP, sum(thanhTien) as totalSold
from HoaDonChiTiet as a join SanPham as b on a.maSP = b.maSP
group by a.maSP, b.tenSP

-- cau 6
select a.maHD, b.maSP, c.tenSP, b.donGia, b.soLuong, b.giamGia, b.thanhTien
from HoaDon as a join HoaDonChiTiet as b on a.maHD = b.maHD 
join SanPham as c on b.maSP = c.maSP
where b.giamGia > 0.01 and b.thanhTien < 10000

-- cau 7
select a.maKH, a.tenKH, a.diaChi, a.phone, count(*) totalBill
from HoaDon as b join KhachHang as a on a.maKH = b.maKH
where  MONTH(b.ngayLapHD) = 3 and YEAR(b.ngayLapHD) = 1997
group by a.maKH, a.tenKH, a.diaChi, a.phone
order by a.tenKH asc

-- cau 8
select b.tenSP, count(a.maSP) as tongSoHang, sum(a.thanhTien) as TongTien
from HoaDonChiTiet as a join SanPham as b on a.maSP = b.maSP 
group by b.tenSP with rollup

-- cau 9
select a.maKH, a.tenKH, sum(c.thanhTien) as tongTienDaMua
from KhachHang as a join HoaDon as b on a.maKH = b.maKH 
join HoaDonChiTiet as c on b.maHD = c.maHD
where month(b.ngayLapHD) = 11 and YEAR(b.ngayLapHD) = 2006
group by a.maKH, a.tenKH

-- cau 10
select a.maNV, a.hoTen, sum(c.thanhTien) as tongTienBanDuoc
from NhanVien as a join HoaDon as b on a.maNV = b.maNV 
join HoaDonChiTiet as c on b.maHD = c.maHD
where MONTH(b.ngayLapHD) = 11 and YEAR(b.ngayLapHD) = 2006
group by a.maNV, a.hoTen


