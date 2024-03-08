use PE_DBI202
-- cau 2
select d.Dname department, avg(e.salary) [average salary] from DEPARTMENT d, EMPLOYEE e
where d.Dnumber = e.Dno 
group by d.Dname
-- cau 3

select e1.Fname, e1.Lname from EMPLOYEE e1, EMPLOYEE e2
where e1.Ssn = e2.Super_ssn
group by e1.Fname, e1.Lname
having count(e2.Ssn)  >= 7
order by count(e2.Ssn) desc

-- cau 4
select e.Ssn, count(d.Essn), e.Fname [Employee's Name] from [DEPENDENT] d join EMPLOYEE e
on e.Ssn = d.Essn where d.Relationship like 'Child'
group by e.Ssn, e.Fname
having count(d.Essn) > 2
 -- cau 5
 select d.Dnumber, d.Dname, count(*) NumberOfEmployee from DEPARTMENT d 
 join  EMPLOYEE e on d.Dnumber = e.Dno
 where e.Salary > 40000 and d.Dnumber in (SELECT e1.Dno
FROM EMPLOYEE e1
GROUP BY e1.Dno
HAVING COUNT(*) > 5)
 group by d.Dnumber, d.Dname
 order by NumberOfEmployee desc
 -- cau 7
 select d.Dnumber, d.Dname from DEPARTMENT d 
 where d.Dnumber not in (select e.Dno from EMPLOYEE e join WORKS_ON w
 on e.Ssn = w.Essn 
 join PROJECT p on p.Pnumber = w.Pno
 where p.Pname = 'ProductZ'
)
--cau 8
create proc proc_SumSalary
@depNo int , @sumOfSalarys int output
as
begin
	set @sumOfSalarys = (select sum(e.Salary) from EMPLOYEE e, DEPARTMENT d
	where e.Dno = d.Dnumber and d.Dnumber = 1
	group by d.Dnumber)
end
-- cau 9
drop trigger tr_no_insert
CREATE TRIGGER tr_no_insert
on EMPLOYEE instead of insert
as
BEGIN
	if (select Dno from inserted) not in (select d.Dnumber from EMPLOYEE e, DEPARTMENT d
	where e.Dno = d.Dnumber
	group by d.Dnumber
	having count(*)  > 5) 
	Begin 
		print 'inserted'
	end
	else
	begin 
		print 'no inserted'
	end

end

insert into EMPLOYEE
values ('Tester', 'T', 'Tester', 000111000, '2023/03/07', 'testing','F', 40000, 987654321, 3)
select * from EMPLOYEE
-- cau 6
--cachs 1
SELECT E.*
FROM EMPLOYEE E
LEFT JOIN DEPENDENT D ON E.Ssn = D.Essn
WHERE D.Dependent_name IS NULL OR DATEDIFF(year, D.Bdate, GETDATE()) < 18
GROUP BY E.Ssn, E.Fname, E.Lname, E.Address, E.Salary, E.Sex, E.Bdate, E.Dno, E.Super_ssn, E.Minit
HAVING COUNT(D.Dependent_name) = SUM(CASE WHEN DATEDIFF(year, D.Bdate, GETDATE()) < 18 THEN 1 ELSE 0 END)
order by E.Fname

--cachs 2

select * FROM EMPLOYEE WHERE EMPLOYEE.Ssn NOT IN (
SELECT  e.Ssn from EMPLOYEE as e
JOIN DEPENDENT AS d ON d.Essn = e.Ssn)
UNION 
SELECT  e.* FROM EMPLOYEE AS e
JOIN DEPENDENT as d ON d.Essn = e.Ssn
WHERE YEAR(GETDATE()) - YEAR(d.Bdate) < 18 AND e.Ssn NOT IN(
SELECT EMP.Ssn FROM EMPLOYEE AS EMP
JOIN DEPENDENT ON DEPENDENT.Essn = EMP.Ssn
WHERE YEAR(GETDATE()) - YEAR(DEPENDENT.Bdate) >= 18)

