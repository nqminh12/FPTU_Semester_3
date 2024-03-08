use SE1762
/*
	insert into table values(list of values)
	insert into table(list of frields) values(list of values as fields)
*/
-- nếu àm khóa chính là identity --> không được insert gia tri khóa chính
insert into Customer values(1, 'thanh tung', 'tung123','1223')
-- pass word >= 8
insert into Customer values('thanh tung', 'tung123','1223')
--
insert into Customer values('thanh tung', 'tung123','12234424234')
select * from Customer
--
insert into Customer values('thanh tung','12234424234','tung1234')
-- danh sach value phai day du nhu danh sach cac truong
insert into Customer values('thanh tung')
-- 
insert into Customer(cusName, userName, password) values('Thanh Hai', 'hai', 'hai123456')
--khong nhap truong null hoặc default
insert into Customer(cusName, userName) values('tuan hai' , 'tuan hai')

--khóa chính phải tồn tại trước khóa ngoại --> nhập bên 1 trước bên nhiều
-- toàn vẹn khóa ngoại: giá trị khóa ngoại chỉ được phép nhập giá trị của khóa chính đã tồn tại
select * from Customer
insert into Bill(billID, dateCreate, totalBill,cusID)
values ('b01',GETDATE(), 1000 , 2)
select * from Bill
-- khóa chính bị trùng
insert into Bill(billID, dateCreate, totalBill,cusID)
values ('b01',GETDATE(), 1000 , 2)
-- change pk
insert into Bill(billID, dateCreate, totalBill,cusID)
values ('b02','5/23/2023', 1001 , 3)
--
insert into Bill(billID, totalBill,cusID)
values ('b04', 1001 , 4)

insert into Products(pid, pname, quantity, price)
values('p01','Dell',GETDATE() + 1 , 100, 2000)
select * from Products