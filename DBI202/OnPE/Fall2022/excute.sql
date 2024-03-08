-- cau 2
select s.StockItemID, s.StockItemName, s.SupplierID, s.Color from StockItems s
where s.Color = 'Blue'
-- cau 3
select s.SupplierTransactionID, ss.SupplierID, ss.SupplierName, s.TransactionDate, s.TransactionAmount from SupplierTransactions s, Suppliers ss
where s.SupplierID = ss.SupplierID and s.TransactionDate between '2013-02-01' and '2013-02-15'
-- cau 4
Select st.StockItemID, st.StockItemName, s.SupplierID, s.SupplierName, st.OuterPackageID,p.PackageTypeName OuterPackageTypeName,st.UnitPrice from PackageTypes p, Suppliers s, StockItems st
where s.SupplierID = st.SupplierID and p.PackageTypeID = st.OuterPackageID and st.StockItemID >= 135 
order by p.PackageTypeName asc , st.StockItemName asc 
-- cau 5
select s.SupplierID, s.SupplierName, count(p.PurchaseOrderID) NumberOfPurchaseOrders from Suppliers s 
left join PurchaseOrders p on s.SupplierID = p.SupplierID
group by s.SupplierID, s.SupplierName
order by NumberOfPurchaseOrders desc, s.SupplierName asc
-- cau 6
select s.UnitPackageID, p.PackageTypeName UnitPackageTypeName, count(s.UnitPackageID) NumberOfStockItems from PackageTypes p , StockItems s
where p.PackageTypeID = s.UnitPackageID
group by s.UnitPackageID, p.PackageTypeName
having count(s.UnitPackageID) = (select top 1 count(s.UnitPackageID) from PackageTypes p , StockItems s
where p.PackageTypeID = s.UnitPackageID
group by p.PackageTypeID
order by count(s.UnitPackageID))
-- cau 7
select c.PackageTypeID, c.PackageTypeName, c.NumberOfStockItems_UnitPackage, cc.NumberOfStockItems_OuterPackage from (select p.PackageTypeID, p.PackageTypeName, count(s.UnitPackageID) NumberOfStockItems_UnitPackage from PackageTypes p
left join StockItems s on s.UnitPackageID = p.PackageTypeID
where p.PackageTypeName in ('Each', 'Carton', 'Packet', 'Bag', 'Box', 'Pair')
group by p.PackageTypeID, p.PackageTypeName) as c
join (select p.PackageTypeID, p.PackageTypeName, count(st.OuterPackageID) NumberOfStockItems_OuterPackage from PackageTypes p
left join StockItems st on st.OuterPackageID = p.PackageTypeID
where p.PackageTypeName in ('Each', 'Carton', 'Packet', 'Bag', 'Box', 'Pair')
group by p.PackageTypeID, p.PackageTypeName) as cc on cc.PackageTypeID = c.PackageTypeID and cc.PackageTypeName = c.PackageTypeName
order by NumberOfStockItems_OuterPackage desc, PackageTypeName asc
-- cau 8
create proc Proc4
@stockItemID int, @OrderYear int, @numberOfPurchaseOrders int output
as
begin
	set @numberOfPurchaseOrders = (select count(*) from StockItems st, PurchaseOrderLines p, PurchaseOrders po
where st.StockItemID = p.StockItemID and p.PurchaseOrderID = po.PurchaseOrderID
and st.StockItemID = @stockItemID and year(po.OrderDate) = @OrderYear
group by st.StockItemID)
end
-- cau 9
create trigger Tr4
on StockItems after insert 
as
begin
	select st.StockItemID, st.StockItemName,st.OuterPackageID, p.PackageTypeName OuterPackageTypeName, st.UnitPrice, st.TaxRate from inserted st, PackageTypes p
where p.PackageTypeID = st.OuterPackageID

end
-- cau 10
delete from PackageTypes
where PackageTypeID not in (select distinct p.PackageTypeID from PackageTypes p, StockItems st
where p.PackageTypeID = st.UnitPackageID
union
select distinct p.PackageTypeID from PackageTypes p, StockItems st
where p.PackageTypeID = st.OuterPackageID
)
--cau 1
create database pesampleERD
use pesampleERD

create table Staffs(
StaffID int primary key,
[Name] nvarchar(100)
)

create table Logins(
username nvarchar(50) primary key,
[Password] nvarchar(50),
[Role] nvarchar(100),
StaffID int foreign key references Staffs(StaffID)
)

create table Reports(
ReportNumber int primary key,
[Date] date,
IssueReturn  nvarchar(200),
username nvarchar(50) foreign key references Logins(username)
)











