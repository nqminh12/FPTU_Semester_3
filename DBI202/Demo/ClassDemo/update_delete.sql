use Northwind
select * from Products
/*
	update table set fieldName = expression,... where condition
*/
-- update ko co where --> update all records
update Products set Discontinued = 1
--
update Products set Discontinued = 0 where UnitsInStock = 0
--
update Products set Discontinued = 0 where UnitsOnOrder = 0
--
update Products set UnitPrice = UnitPrice*1.05, UnitsInStock = UnitsInStock + 10 where UnitsOnOrder > 30
--
/*
	compare operator: > < >= <= <>
*/
update Products set UnitPrice = UnitPrice*1.05, UnitsInStock = UnitsInStock + 10 where Discontinued <> 0

/*
	String operator like
	%: thay the cho string bat ki     
	ex: ProductName like %abc% -> tồn tại abc trong product name
	ex: ProductName Like abc% : productName bắt đầu là abc
	ex: ProductName Like %abc : productName kết thức là abc

	_ :thay thế cho 1 và chỉ 1 kí tự
	ex: ProductName like 'abc_' : ten bắt đầu bằng abc và sau đó có duy nhất 1 kí tự

	[]: Dùng để chỉ tồn tại trong khoảng hoặc danh sách
	ex: ProductName like '[agy]%': bắt đầu bằng a hoặc g hoặc y
	ex: ProductName like '[a-d]%': bắt đầu bằng ký tự trong khoảng từ a đến d
	ex: ProductName like '[a-dx]%': bắt đầu bằng ký tự trong khoảng từ a đến d hoặc x

	^: phủ định cho khoảng
	ex: ProductName like '[^a-dx]%': không bắt đầu bằng ký tự trong khoảng từ a đến d hoặc x
*/

select * from Products where ProductName like '%Cha%'
select * from Products where ProductName like 'Ch_%'
select * from Products where ProductName like '[CAX]%'

/*

	logic operator: NOT AND OR
*/
select * from Products where ProductName not like 'Cha_'
select * from Products where ProductName like 'C%' AND UnitPrice >= 19
select * from Products where ProductName like 'C%' OR UnitPrice >= 19

--constrais update

update Products set UnitPrice = UnitPrice*0.9 where ProductID = 1
select * from Products
go
-- ko update được identity
update Products set UnitPrice = UnitPrice*0.9, ProductID = 3000 where ProductID = 1
go
select * from Territories
select * from EmployeeTerritories 
-- update primary key 
update Territories set TerritoryID = '11111' where TerritoryID = '06897'
-- foreign key constrains
-- giá trị khóa ngoại chỉ được phép nhận giá trị khóa chính đã tồn tại
-- nếu giá trị khóa chính đã tồn tại trên khóa ngoại thì không được sửa hoặc xóa khóa chính
select * from Territories
where TerritoryID not in (select distinct TerritoryID from EmployeeTerritories)
update Territories set TerritoryID = '11111' where TerritoryID = '29202'

-- delete from table where condition
delete Territories where TerritoryID = '11111'
delete Territories where TerritoryID = '01581'


