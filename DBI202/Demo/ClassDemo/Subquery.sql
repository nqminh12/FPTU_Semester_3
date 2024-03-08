use Northwind

/*
subquery: câu lệnh sql có thể lồng nhau: subquery --> câu lệnh bên trong chạy trước, trả lại kết quả cho câu lệnh bên ngoài
subquery có thể thực hiện trên tất cả các câu lệnh insert, update, delete, select
*/

select * from Categories
select * from Suppliers
select * from Products

Insert into Products(ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice,
UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued)
values('new product', (select SupplierID from Suppliers where CompanyName = 'Exotic Liquids'),
(select CategoryID from Categories where CategoryName = 'Beverages'), 'abc',1,1,1,1,1)
--xóa tất cả các category không có trên products
delete from Categories 
where CategoryID not in(select distinct CategoryID from Products)
-- danh sach ca product da ban được
select * from Products
where ProductID in (select distinct ProductID from [Order Details]) 
-- danh sach manager
select * from Employees
where EmployeeID in (select distinct ReportsTo from Employees)
-- danh sách nhân viên
select * from Employees
where EmployeeID not in (select distinct ReportsTo from Employees)
-- danh sách các mặt hàng có price lớn nhất (max price)
select top 1 * from Products
order by UnitPrice desc-- sai
-- 
select * from Products
where UnitPrice = (select max(UnitPrice) from Products)
--
select c.CategoryID, c.CategoryName, --b.SupplierID , b.CompanyName,  
	count(a.UnitsInStock) as numberOfProductsBySupplier,
	sum(a.UnitsInStock) as OfProductByCategory
from Products as a join Suppliers as b on a.SupplierID=b.SupplierID
	join Categories as c on a.CategoryID=c.CategoryID
group by c.CategoryID,c.CategoryName --,b.SupplierID,b.CompanyName
--having count(a.UnitsInStock)>1
order by COUNT(a.UnitsInStock) desc
-- danh sach cac category co max cua count

select c.CategoryID, c.CategoryName, --b.SupplierID , b.CompanyName,  
	count(a.UnitsInStock) as numberOfProductsBySupplier,
	sum(a.UnitsInStock) as OfProductByCategory
from Products as a join Suppliers as b on a.SupplierID=b.SupplierID
	join Categories as c on a.CategoryID=c.CategoryID
group by c.CategoryID,c.CategoryName --,b.SupplierID,b.CompanyName
having count(a.UnitsInStock)>= all(select count(a.UnitsInStock) from Products as a join Suppliers as b
									on a.SupplierID = b.SupplierID
									join Categories as c on a.CategoryID = c.CategoryID
									group by c.CategoryID, c.CategoryName)
order by COUNT(a.UnitsInStock) desc
--
select c.CategoryID, c.CategoryName, --b.SupplierID , b.CompanyName,  
	count(a.UnitsInStock) as numberOfProductsBySupplier,
	sum(a.UnitsInStock) as OfProductByCategory
from Products as a join Suppliers as b on a.SupplierID=b.SupplierID
	join Categories as c on a.CategoryID=c.CategoryID
group by c.CategoryID,c.CategoryName --,b.SupplierID,b.CompanyName
having count(a.UnitsInStock)<= all(select count(a.UnitsInStock) from Products as a join Suppliers as b
									on a.SupplierID = b.SupplierID
									join Categories as c on a.CategoryID = c.CategoryID
									group by c.CategoryID, c.CategoryName)
order by COUNT(a.UnitsInStock) desc	











