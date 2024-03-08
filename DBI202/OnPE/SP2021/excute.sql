use PE_DBI202_Sp2021_B5
-- cau 2
select * from Employees
where Salary > 9000
-- cau 3
select j.JobID, j.JobTitle, j.min_salary from Jobs j
where j.min_salary > 5000 and j.JobTitle like '%Manager%'
order by j.min_salary desc, j.JobTitle asc
-- cau 4
select e.EmployeeID, e.FirstName, e.LastName, e.Salary, d.DepartmentName, l.StateProvince, l.CountryID from Employees e, Departments d, Locations l
where e.DepartmentID = d.DepartmentID and d.LocationID = l.LocationID and e.Salary > 3000 and l.StateProvince like 'Washington'
and l.CountryID like 'US'
-- cau 5
select l.LocationID, l.StreetAddress, l.City, l.StateProvince, l.CountryID, count(d.DepartmentID) NumberOfDepartments  from Departments d right join Locations l
on d.LocationID = l.LocationID 
group by l.LocationID, l.StreetAddress, l.City, l.StateProvince, l.CountryID
order by NumberOfDepartments desc, l.LocationID asc
-- cau 6
select j.JobID, j.JobTitle, count(e.EmployeeID) as NumberOfEmployees from Jobs j , Employees e
where j.JobID = e.JobID
group by j.JobID, j.JobTitle
having COUNT(e.EmployeeID) = (select top 1 count(e.EmployeeID) as NumberOfEmployees from Jobs j , Employees e
where j.JobID = e.JobID
group by j.JobID
order by NumberOfEmployees desc)
-- cau 7 
select e2.EmployeeID,e2.FirstName, e2.LastName,e2.Salary,e2.DepartmentID, d.DepartmentName ,count(e1.EmployeeID) NumberOfSubordinates from Employees e1
right join Employees e2 on e2.EmployeeID = e1.ManagerID
join Departments d on d.DepartmentID = e2.DepartmentID
where e2.EmployeeID in (Select e2.EmployeeID from Employees e2 where e2.Salary > 10000
Union
Select e2.EmployeeID from Employees e2 , Employees e1 where e2.EmployeeID = e1.ManagerID)
group by e2.EmployeeID, e2.FirstName, e2.LastName,e2.Salary,e2.DepartmentID, d.DepartmentName 
order by NumberOfSubordinates desc, e2.LastName asc
-- cau 8

create proc pr1 
@countryID varchar(10), @numberOfDepartments int output
as
begin
	set @numberOfDepartments = (select count(d.DepartmentID) from Departments d, Locations l, Countries c
where d.LocationID = l.LocationID and l.CountryID = c.CountryID and c.CountryID like @countryID
group by l.CountryID
)
end
-- cau 9
drop trigger Tr1
create trigger Tr1
on Employees after insert
as
begin
	select e.EmployeeID, e.FirstName, e.LastName, d.DepartmentID, d.DepartmentName from inserted e left join Departments d
	on d.DepartmentID = e.DepartmentID 
end

insert into Employees(EmployeeID, FirstName, LastName, Email, JobID, DepartmentID)
values 
(1007, 'Muriel', 'Visani', 'muriel.visani@gmail.com', 'SA_REP', null)

select e.EmployeeID, e.FirstName, e.LastName, d.DepartmentID, d.DepartmentName from Employees e, Departments d
	where d.DepartmentID = e.DepartmentID 
-- cau 10

delete Departments where DepartmentID not in (select d.DepartmentID from Departments d, Employees e
where d.DepartmentID = e.DepartmentID)


select * from Departments



-- cau 9 update





