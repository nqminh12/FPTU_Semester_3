create database QLDON
use QLDON

-----
create table KhachHang(maKH varchar(5) primary key, tenKH varchar(30) not null, diaChi varchar(50),
dt varchar(10) check(len(dt)>=7 AND len(dt)<=10) , email varchar(30))

insert into KhachHang values('KH01', 'NGUYEN THI BE', 'TAN BINH', '8457895', 'bnt@yahoo.com')
insert into KhachHang values('KH02', 'LE HOANG NAM', 'BINH CHANH', '9878987', 'namlehoang@abc.com')
insert into KhachHang values('KH03', 'TRAN THI CHIEU', 'TAN BINH', '8457895', null)
insert into KhachHang values('KH04', 'MAI THI QUE ANH', 'BINH CHANH', null, null)
insert into KhachHang values('KH05', 'LE VAN SANG', 'QUAN10', null, 'sanglv@hcm.vnn.vn')
insert into KhachHang values('KH06', 'TRAN HOANG KHAI', 'TAN BINH', '8457897', null)
select *from KhachHang
-----
create table SanPham(maVT varchar(10) primary key, tenVT varchar(30) not null, DVT varchar(20),
giaMua int check(giaMua >0), slTon int check(slTon>=0))

insert into SanPham values('VT01', 'XI MANG', 'BAO', '50000', '5000')
insert into SanPham values('VT02', 'CAT', 'KHOI', '45000', '50000')
insert into SanPham values('VT03', 'GACH ONG', 'VIEN', '120', '800000')
insert into SanPham values('VT04', 'GACH THE', 'VIEN', '110', '800000')
insert into SanPham values('VT05', 'DA LON', 'KHOI', '25000', '100000')
insert into SanPham values('VT06', 'DA NHO', 'KHOI', '33000', '100000')
select * from SanPham
-----
create table HoaDon(maHD varchar(10) primary key, ngay date, 
maKH varchar(5) foreign key references KhachHang(maKH),
tongTG int)

insert into HoaDon(maHD,ngay,maKH) values('HD01', '12/05/2000', 'KH01')
insert into HoaDon(maHD,ngay,maKH) values('HD02', '05/25/2000', 'KH02')
insert into HoaDon(maHD,ngay,maKH) values('HD03', '05/25/2000', 'KH01')
insert into HoaDon(maHD,ngay,maKH) values('HD04', '05/25/2000', 'KH04')
insert into HoaDon(maHD,ngay,maKH) values('HD05', '05/26/2000', 'KH04')
insert into HoaDon(maHD,ngay,maKH) values('HD06', '06/02/2000', 'KH03')
insert into HoaDon(maHD,ngay,maKH) values('HD07', '06/22/2000', 'KH04')
insert into HoaDon(maHD,ngay,maKH) values('HD08', '06/25/2000', 'KH03')
insert into HoaDon(maHD,ngay,maKH) values('HD09', '08/15/2000', 'KH04')
insert into HoaDon(maHD,ngay,maKH) values('HD010', '09/30/2000', 'KH01')
select * from HoaDon
-----
create table ChiTietHoaDon(maHD varchar(10) foreign key references HoaDon(maHD),
maVT varchar(10) foreign key references SanPham(maVT),
primary key(maHD,maVT),
SL int check(SL>0), khuyenMai int, giaBan int)

insert into ChiTietHoaDon(maHD, maVT,SL, giaBan) values('HD01', 'VT01', '5', '52000')
insert into ChiTietHoaDon(maHD, maVT,SL, giaBan) values('HD01', 'VT05', '10', '30000')
insert into ChiTietHoaDon(maHD, maVT,SL, giaBan) values('HD02', 'VT03', '10000', '150')
insert into ChiTietHoaDon(maHD, maVT,SL, giaBan) values('HD03', 'VT02', '20', '55000')
insert into ChiTietHoaDon(maHD, maVT,SL, giaBan) values('HD04', 'VT03', '50000', '150')
insert into ChiTietHoaDon(maHD, maVT,SL, giaBan) values('HD04', 'VT04', '20000', '120')
insert into ChiTietHoaDon(maHD, maVT,SL, giaBan) values('HD05', 'VT05', '10', '30000')
insert into ChiTietHoaDon(maHD, maVT,SL, giaBan) values('HD06', 'VT04', '10000', '120')
insert into ChiTietHoaDon(maHD, maVT,SL, giaBan) values('HD07', 'VT04', '20000', '125')
insert into ChiTietHoaDon(maHD, maVT,SL, giaBan) values('HD08', 'VT01', '100', '55000')
insert into ChiTietHoaDon(maHD, maVT,SL, giaBan) values('HD09', 'VT02', '25', '48000')
insert into ChiTietHoaDon(maHD, maVT,SL, giaBan) values('HD010', 'VT01', '25', '57000')
select *from ChiTietHoaDon

-----
update KhachHang set tenKH='NGUYEN THI THOM' where tenKH='NGUYEN THI BE'
select * from KhachHang
UPDATE HoaDon set maKH='KH06' where maKH='KH01'
select * from HoaDon
-----
delete ChiTietHoaDon where SL='5'
select * from ChiTietHoaDon

-- cau 2
select * from KhachHang
where diaChi = 'TAN BINH'

-- cau 3
select * from SanPham
where tenVT like 'GACH%' and giaMua > 110

-- cau 4
select b.maHD, b.ngay, a.tenKH, a.diaChi, a.dt from KhachHang as a
join HoaDon as b on a.maKH = b.maKH
order by b.ngay asc

-- cau 5
select a.maKH,  a.diaChi, a.dt
from KhachHang as a 
left join HoaDon as b on a.maKH = b.maKH and MONTH(b.ngay) = 6 
and YEAR(b.ngay) = 2000
where  b.maHD is null


-- cau 6
select a.maHD, b.maVT, b.tenVT, b.DVT, a.giaBan, b.giaMua, a.SL, (b.giaMua * a.SL) as TriGiaMua, (a.giaBan * a.SL) as TriGiaBan
from SanPham as b join ChiTietHoaDon as a on a.maVT = b.maVT 
where a.giaBan > b.giaMua

select a.maHD, b.maVT, b.tenVT, b.DVT, a.giaBan, b.giaMua, a.SL, (b.giaMua * a.SL) as TriGiaMua, (a.giaBan * a.SL) as TriGiaBan
from ChiTietHoaDon as a join SanPham as b on a.maVT = b.maVT 
where a.giaBan > b.giaMua


-- cau 7
select a.maHD, b.ngay, b.maKH, c.tenKH, c.diaChi, sum(giaBan*SL) as TongGiaTri
from ChiTietHoaDon as a join HoaDon as b on a.maHD = b.maHD
join KhachHang as c on b.maKH = c.maKH
group by a.maHD, b.ngay, b.maKH, c.tenKH, c.diaChi
having sum(giaBan*SL) = (select max(TongGiaTri) 
						from (select maHD,sum(giaBan*SL) as TongGiaTri
						from ChiTietHoaDon group by maHD) as Subquery)

select a.maHD, b.ngay, b.maKH, c.tenKH, c.diaChi, sum(giaBan*SL) as TongGiaTri
from ChiTietHoaDon as a join HoaDon as b on a.maHD = b.maHD
join KhachHang as c on b.maKH = c.maKH
group by a.maHD, b.ngay, b.maKH, c.tenKH, c.diaChi
having sum(giaBan*SL) = (select max(TongGiaTri) 
						from (select b.maHD,sum(giaBan*SL) as TongGiaTri
						from ChiTietHoaDon as a join HoaDon as b on a.maHD = b.maHD
join KhachHang as c on b.maKH = c.maKH group by b.maHD) as Subquery)


-- cau 8
select a.maVT, a.tenVT, a.DVT, a.giaMua, count(distinct maHD) as 'SLHoaDon'
from SanPham as a join ChiTietHoaDon as b on a.maVT = b.maVT
group by a.maVT, a.tenVT, a.DVT, a.giaMua
having count(distinct maHD) = (select min(SLHoaDon) from (select a.maVT, a.tenVT, a.DVT, a.giaMua, 
								count(distinct maHD) as 'SLHoaDon'
								from SanPham as a join ChiTietHoaDon as b on a.maVT = b.maVT
								group by a.maVT, a.tenVT, a.DVT, a.giaMua) as Subquery)