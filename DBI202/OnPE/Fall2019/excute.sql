use PE_DBI202_F2019

--cau 2
select * from Locations l
where l.CountryID = 'US' or l.CountryID = 'CA'
--cau 3
select e.EmployeeID, e.FirstName, e.LastName, e.Salary, e.Commission_pct,e.HireDate from Employees e
where e.Salary between 4000 and 10000 and e.Commission_pct > 0 and e.FirstName like '%e%'
order by e.HireDate desc
--cau 4
select e.EmployeeID, e.FirstName, e.LastName, e.HireDate, e.JobID, j.JobTitle, e.DepartmentID, d.DepartmentName from Employees e, Departments d, Jobs j
where e.DepartmentID = d.DepartmentID and j.JobID = e.JobID and year(e.HireDate) = 2005 and j.JobTitle = 'Stock Clerk'
--cau 5
select e.JobID, j.JobTitle, count(e.JobID) as NumberOfEmployess  from Employees e, Jobs j
where e.JobID = j.JobID 
group by e.JobID, j.JobTitle
order by NumberOfEmployess desc
--cau 6
select * from Countries
where CountryID not in (Select distinct l.CountryID from Locations l, Departments d 
where l.LocationID = d.LocationID)
--cau 7
SELECT b.EmployeeID ,b.FirstName ,b.LastName,b.DepartmentID,c.DepartmentName,COUNT(a.EmployeeID) AS NumberOfSubordinates
FROM  Employees a
RIGHT JOIN Employees b ON b.EmployeeID = a.ManagerID
INNER JOIN Departments c ON c.DepartmentID = b.DepartmentID
WHERE  b.EmployeeID in 
(Select e.EmployeeID from Employees e, Departments d where e.DepartmentID = d.DepartmentID and d.DepartmentName = 'IT'
Union
Select e.EmployeeID from Employees e , Employees e1 where e.EmployeeID = e1.ManagerID)
GROUP BY b.EmployeeID, b.FirstName,b.LastName,b.DepartmentID,c.DepartmentName
ORDER BY NumberOfSubordinates DESC
-- cau 8
create proc proc2
@fromDate date, @toDate date, @numberOfEmployess int output
as
begin 
	set @numberOfEmployess = (select count(*) from Employees e where e.HireDate between @fromDate and @toDate)
end

-- cau 9
create trigger Tr2
on Departments for update
as
begin 
	select d.DepartmentID, d.DepartmentName, d.ManagerID as OldManagerID, i.ManagerID as NewManagerID from inserted i, deleted d where i.DepartmentID = d.DepartmentID
	order by d.DepartmentID DESC
end

--cau 10
delete from Locations
where LocationID not in (select l.LocationID from Locations l, Departments d
where l.LocationID = d.LocationID)

select * from Locations




























