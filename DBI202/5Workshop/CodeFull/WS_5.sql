create database QLDiemSV
use QLDiemSV

-----
CREATE TABLE Khoa (
MaKhoa int identity(1,1) PRIMARY KEY,
TenKhoa nvarchar(50) NOT NULL,
SoCBGD int NOT NULL
);

CREATE TABLE Lop (
MaLop int identity(1,1) PRIMARY KEY,
TenLop nvarchar(50) NOT NULL,
MaKhoa int NOT NULL,
CONSTRAINT fk_Lop_Khoa FOREIGN KEY (MaKhoa) REFERENCES Khoa(MaKhoa)
);

CREATE TABLE SinhVien (
MaSV int identity(1,1) PRIMARY KEY,
HoTen nvarchar(50) NOT NULL,
Nu bit NOT NULL,
NgaySinh date NOT NULL,
MaLop int NOT NULL,
HocBong int NOT NULL,
Tinh nvarchar(50) NOT NULL,
CONSTRAINT fk_SV_Lop FOREIGN KEY (MaLop) REFERENCES Lop(MaLop)
);



CREATE TABLE MonHoc (
MaMH int identity(1,1) PRIMARY KEY,
TenMH nvarchar(50) NOT NULL,
SoTiet int NOT NULL
);

CREATE TABLE KetQua (
MaKQ int identity(1,1) PRIMARY KEY,
MaSV int NOT NULL,
MaMH int NOT NULL,
DiemThi float NOT NULL,
CONSTRAINT fk_KQ_SV FOREIGN KEY (MaSV) REFERENCES SinhVien(MaSV),
CONSTRAINT fk_KQ_MH FOREIGN KEY (MaMH) REFERENCES MonHoc(MaMH)
);

-- Nhập dữ liệu cho bảng Khoa
INSERT INTO Khoa (TenKhoa, SoCBGD) VALUES
('Khoa Công nghệ thông tin', 10),
('Khoa Kinh tế', 8),
('Khoa Ngoại ngữ', 6);

-- Nhập dữ liệu cho bảng Lop
INSERT INTO Lop (TenLop, MaKhoa) VALUES
('CNTT1', 1),
('KT1', 2),
('NN1', 3),
('CNTT2', 1),
('KT2', 2),
('NN2', 3);

-- Nhập dữ liệu cho bảng SinhVien
INSERT INTO SinhVien (HoTen, Nu, NgaySinh, MaLop, HocBong, Tinh) VALUES
('Nguyen Van A', 0, '2000-01-01', 1, 5000000, 'Hà Nội'),
('Tran Thi B', 1, '2001-02-02', 2, 4000000, 'Hồ Chí Minh'),
('Pham Van C', 0, '2002-03-03', 3, 3000000, 'Đà Nẵng'),
('Le Thi D', 1, '2003-04-04', 1, 2000000, 'Hải Phòng'),
('Hoang Van E', 0, '2004-05-05', 2, 1500000, 'Nghệ An'),
('Ngo Thi F', 1, '2005-06-06', 3, 1000000, 'Bình Định');

-- Nhập dữ liệu cho bảng MonHoc
INSERT INTO MonHoc (TenMH, SoTiet) VALUES
('CSDL', 60),
('CSDL', 60),
('CSDL', 60),
('CSDL', 30),
('CSDL', 30),
('CSDL', 30);

-- Nhập dữ liệu cho bảng KetQua
INSERT INTO KetQua (MaSV, MaMH, DiemThi) VALUES
(1, 1, 8.5),
(1, 2, 7.5),
(2, 1, 9),
(2, 2, 6.5),
(3, 3, 8),
(3, 4, 5.5),
(4, 3, 7),
(4, 4, 9),
(5, 5, 8.5),
(5, 6, 7),
(6, 5, 6.5),
(6, 6, 8);
----- Câu 1:
select * from Lop
----- Câu 2:
SELECT MaSV, HoTen, HocBong
FROM SinhVien
----- Câu 3:
SELECT MaSV, Nu, HocBong
FROM SinhVien
WHERE HocBong != 0
----- Câu 4
SELECT *
FROM SinhVien
WHERE Nu = 1
----- Câu 5
SELECT *
FROM SinhVien
WHERE HoTen LIKE 'Trần%'
----- Câu 6
SELECT *
FROM SinhVien
WHERE Nu = 1 AND HocBong != 0
----- Câu 7
SELECT *
FROM SinhVien
WHERE Nu = 1 OR HocBong != 0
----- Câu 8
SELECT *
FROM SinhVien
WHERE YEAR(NgaySinh) BETWEEN 1978 AND 1985
----- Câu 9
SELECT *
FROM SinhVien
ORDER BY MaSV ASC
----- Câu 10
SELECT *
FROM SinhVien
ORDER BY HocBong DESC
----- Câu 11:
SELECT SinhVien.*
FROM SinhVien
JOIN KetQua ON SinhVien.MaSV = KetQua.MaSV
JOIN MonHoc ON KetQua.MaMH = MonHoc.MaMH
WHERE MonHoc.TenMH = 'CSDL' AND KetQua.DiemThi >= 8

----- Câu 12
SELECT sv.MaSV, sv.HoTen, sv.HocBong, l.TenLop
FROM SinhVien AS sv JOIN Lop AS l ON sv.MaLop = l.MaLop
JOIN Khoa AS k ON l.MaKhoa = k.MaKhoa
WHERE k.TenKhoa = 'Khoa CNTT' AND sv.HocBong > 0;

----- Câu 13
SELECT sv.MaSV, sv.HoTen, sv.HocBong, l.TenLop, k.TenKhoa
FROM SinhVien AS sv JOIN Lop AS l ON sv.MaLop = l.MaLop
JOIN Khoa AS k ON l.MaKhoa = k.MaKhoa
WHERE k.TenKhoa = 'Khoa CNTT' AND sv.HocBong > 0;
----- Câu 14
SELECT l.MaLop, l.TenLop, COUNT(sv.MaSV) AS SoSinhVien
FROM Lop AS l JOIN SinhVien AS sv ON l.MaLop = sv.MaLop
GROUP BY l.MaLop, l.TenLop;
----- Câu 15
SELECT Khoa.MaKhoa, Khoa.TenKhoa, COUNT(SinhVien.MaSV) AS SoLuongSinhVien
FROM Khoa
JOIN Lop ON Khoa.MaKhoa = Lop.MaKhoa
JOIN SinhVien ON Lop.MaLop = SinhVien.MaLop
GROUP BY Khoa.MaKhoa, Khoa.TenKhoa
----- Câu 16
SELECT Khoa.MaKhoa, Khoa.TenKhoa, COUNT(SinhVien.MaSV) AS SoLuongNu
FROM Khoa
JOIN Lop ON Khoa.MaKhoa = Lop.MaKhoa
JOIN SinhVien ON Lop.MaLop = SinhVien.MaLop
WHERE SinhVien.Nu = 1
GROUP BY Khoa.MaKhoa, Khoa.TenKhoa
----- Câu 17
SELECT Lop.MaLop, Lop.TenLop, SUM(SinhVien.HocBong) AS TongTienHocBong
FROM Lop
JOIN SinhVien ON Lop.MaLop = SinhVien.MaLop
GROUP BY Lop.MaLop, Lop.TenLop
----- Câu 18
SELECT Khoa.MaKhoa, Khoa.TenKhoa, SUM(SinhVien.HocBong) AS TongTienHocBong
FROM Khoa
JOIN Lop ON Khoa.MaKhoa = Lop.MaKhoa
JOIN SinhVien ON Lop.MaLop = SinhVien.MaLop
GROUP BY Khoa.MaKhoa, Khoa.TenKhoa
----- Câu 19
SELECT Khoa.MaKhoa, Khoa.TenKhoa, COUNT(SinhVien.MaSV) AS SoLuong
FROM Khoa
JOIN Lop ON Khoa.MaKhoa = Lop.MaKhoa
JOIN SinhVien ON Lop.MaLop = SinhVien.MaLop
GROUP BY Khoa.MaKhoa, Khoa.TenKhoa
HAVING COUNT(SinhVien.MaSV) > 100
----- Câu 20
SELECT Khoa.MaKhoa, Khoa.TenKhoa, COUNT(SinhVien.MaSV) AS SoLuong
FROM Khoa
JOIN Lop ON Khoa.MaKhoa = Lop.MaKhoa
JOIN SinhVien ON Lop.MaLop = SinhVien.MaLop
WHERE SinhVien.Nu = 1
GROUP BY Khoa.MaKhoa, Khoa.TenKhoa
HAVING COUNT(SinhVien.MaSV) > 50

----- Câu 21
SELECT Khoa.MaKhoa, TenKhoa, SUM(HocBong) AS TongHocBong
FROM Khoa
INNER JOIN Lop ON Khoa.MaKhoa = Lop.MaKhoa
INNER JOIN SinhVien ON Lop.MaLop = SinhVien.MaLop
GROUP BY Khoa.MaKhoa, TenKhoa
HAVING SUM(HocBong) >= 1000000;
----- Câu 22
select * from SinhVien
where hocBong = (select max(hocBong) from SinhVien)
----- Câu 23
SELECT SinhVien.HoTen, KetQua.DiemThi
FROM SinhVien
INNER JOIN KetQua ON SinhVien.MaSV = KetQua.MaSV
INNER JOIN MonHoc ON KetQua.MaMH = MonHoc.MaMH and MonHoc.TenMH = 'CSDL'
where DiemThi = (select max(DiemThi) from KetQua)
order by KetQua.DiemThi desc
----- Câu 24
SELECT SinhVien.MaSV, SinhVien.HoTen
FROM SinhVien
LEFT JOIN KetQua ON SinhVien.MaSV = KetQua.MaSV AND KetQua.MaMH = any(SELECT MaMH FROM MonHoc WHERE TenMH = 'CSDL')
WHERE KetQua.MaMH IS NULL;
----- Caau 25
SELECT Khoa.TenKhoa, COUNT(*) AS SoSinhVien 
FROM Khoa
INNER JOIN Lop ON Khoa.MaKhoa = Lop.MaKhoa
INNER JOIN SinhVien ON Lop.MaLop = SinhVien.MaLop
GROUP BY Khoa.TenKhoa
ORDER BY SoSinhVien DESC;



