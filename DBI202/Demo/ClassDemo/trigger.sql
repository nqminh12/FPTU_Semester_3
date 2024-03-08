use Northwind

/*select * from Region
select * from Territories
update Region set RegionID = 10 where RegionID = 1
*/
create trigger CheckUnitInStock -- name off trigger
on Products -- name of table
for insert -- name of action
as
if(select UnitsInStock from inserted) > 20000 -- get unitsInStock in new record 
begin 
	print 'UnitsInStock cannot grater than 20000'--
	rollback transaction -- cancel action
end


create trigger CheckPriceInOrderDetail -- name off trigger
on Products -- name of table
for update -- name of action
as
if(select UnitsInStock from inserted) > (select UnitPrice from deleted)-- get unitsInStock in new record 
begin 
	print 'new price cannot greater than old price'--
	rollback transaction -- cancel action
end

create trigger Check_ProductID
on products
for update
as
if update(ProductID)
begin
print 'You cannot modify the id of an product'
rollback transaction
end

select * from Products
update Products set ProductID = 10001 where ProductID = 1

select * from Customers
update Customers set CustomerID = 'abc' 

create trigger Delete_Category
on Categories
instead of delete
as
begin
-- delete foreign key
delete from [Order Details] where ProductID in
(select ProductID from Products where CategoryID = (select CategoryID from deleted))
--delete foreign key
delete from Products where CategoryID = (select CategoryID from deleted)
--primary key
end







