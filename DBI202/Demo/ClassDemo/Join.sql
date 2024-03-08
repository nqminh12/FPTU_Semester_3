use Northwind

/*
	join: dùng để kết nối dữ liệu các bảng dựa trên các trường có cùng giá trị,
	thông thường là PK vầ FK(khoa schinhs và khóa ngoại)

	innner join: kết hợp hai bảng có mối quan hệ 1-1, 1-n với nhau dựa trên PK và FK
	cứ 1 bản ghi chứa PK bên 1 kết hợp với tất cả các bản ghi chưa khóa ngoại bên nhiều
	để tạo thành các bản ghi mới.
	Trong trường hợp PK không có FK tương ứng thì không tạo bản ghi
	syntag
	select .....
	From tableA as a inner join tableB as b on a.PK = b.FK

	OR use default
	select .....
	From tableA as a join tableB as b on a.PK = b.FK

	note: thứ tự của tableA và tableB có thể đổi nhau
*/

-- Category with products
select a.CategoryID as PK,a.CategoryName, b.CategoryID as FK, b.ProductName, b.UnitPrice, b.UnitsInStock
from Categories as a inner join Products as b on a.CategoryID = b.CategoryID  -- đặt tên 2 bảng thành a và b
order by a.CategoryID

select * from Categories
insert into Categories(CategoryName, Description) values('new cate', 'abc')
delete from Categories where CategoryName = 'new cate'

-- multi join
select a.CategoryID as PK,a.CategoryName, b.CategoryID as FK, b.ProductName,
b.UnitPrice, b.UnitsInStock, c.SupplierID, c.CompanyName, c.ContactName

from Categories as a inner join Products as b on a.CategoryID = b.CategoryID  -- đặt tên 2 bảng thành a và b
	 inner join Suppliers as c on b.SupplierID = c.SupplierID
	 inner join [Order Details] as d on b.ProductID = d.ProductID

order by a.CategoryID

-- outer join 
/*
	select...
	From tableA as a Left | Right | Full outer join tableB as b on a.PK = b.FK

	outer join kết hợp các bảng theo thứ tự:
	left: kết hợp bẳng bên trái với bên phải
	right: phải với trái
	full: song phương
	outer join = inner join + left\right có giá trị khóa mà bên kia không có
	full outer join = left + right
*/
--
select a.CategoryID as PK,a.CategoryName, b.CategoryID as FK, b.ProductName, b.UnitPrice, b.UnitsInStock
from Categories as a left outer join Products as b on a.CategoryID = b.CategoryID  -- đặt tên 2 bảng thành a và b
order by a.CategoryID
--
select a.CategoryID as PK,a.CategoryName, b.CategoryID as FK, b.ProductName, b.UnitPrice, b.UnitsInStock
from Categories as a right outer join Products as b on a.CategoryID = b.CategoryID  -- đặt tên 2 bảng thành a và b
order by a.CategoryID
-- cross join: join giữa hai bảng không dựa trên quan hệ
-- VD: nếu mỗi khách hàng mua đủ danh sách sản phẩm thì số lần bán ra là bao nhiêu
select a.ContactName, b.ProductID, b.ProductName
from Customers as a, Products as b
order by a.ContactName
-- self join: bản chất là quan hệ 1-n trong cùng 1 bảng
-- boyce code 
select * from Employees
--
select Manager.EmployeeID as 'ManagerID', 
Manager.FirstName + ' ' +  Manager.LastName as 'Manager Name',Manager.Title,
Employee.EmployeeID as 'EmployeeID', Employee.FirstName + ' ' +  Employee.LastName as 'Employee Name'

from Employees as Manager inner join Employees as Employee
on Manager.EmployeeID = Employee.ReportsTo
order by [Manager Name]




