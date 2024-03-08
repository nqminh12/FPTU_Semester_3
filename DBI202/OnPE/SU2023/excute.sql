-- cau 2
select * from Assessments
where [percent] = '0.02'
-- cau 3
select s.id Stu_ID, s.name Stu_Name, d.Name Stu_Dep from Students s, Departments d
where s.department = d.Code and d.Name = 'Artificial Intelligence'
order by s.name asc
-- cau 4
select s.id as Stu_ID, s.name as Stu_Name from Courses c, enroll e, Students s
where c.id = e.courseId and e.studentId = s.id and c.credits > 3
-- cau 5
select s.name from semesters se, enroll e, Students s, Courses c, Assessments a
where se.id = e.semesterId and e.studentId = s.id and c.id = e.courseId and a.courseId = c.id  and se.code = 'Fa2022'
and a.type = 'Final Exam'
-- cau 6
select d.Code, d.Name, count(s.id) from Students s, Departments d
where s.department = d.Code
group by d.Code, d.Name		
-- cau 7
select * from (select top 5 s.name from Students s, enroll e, marks m
where s.id = e.studentId and m.enrollId = e.enrollId
group by s.name
order by avg(m.mark) desc) as c
union 
select * from (select top 5 s.name from Students s, enroll e, marks m
where s.id = e.studentId and m.enrollId = e.enrollId
group by s.name
order by avg(m.mark) asc) as cc
-- cau 8
create trigger đ
on Departments after insert
as
begin
	select i.Code Dep_ID, i.Name Dep_Name from inserted i
end
-- cau 9
create proc CalculateAverageStudentMark
@studentID int
as
begin 
	select avg(m.mark) AveRareMark from Students s, enroll e, marks m
	where s.id = e.studentId and m.enrollId = e.enrollId and s.id = @studentID
	group by s.name
end
-- cau 10
delete  Departments 
where Code not in (select distinct d.Code from Departments d, Students s
where d.Code = s.department)
-- cau 1

create table Items(
ItemID int primary key,
Item_Name nvarchar(50),
[Description] nvarchar(100)
)

create table Staffs(
StaffID int primary key,
Staff_Name nvarchar(50),
Manager_Position nvarchar(25)
)

create table Manager(
ManagerID int primary key,
Manager_Name nvarchar(50)
)

create table Care_for(
StaffID int foreign key references Staffs(StaffID),
ManagerID int foreign key references Manager(ManagerID),
primary key(StaffID, ManagerID)
)

create table Manage(
ItemID int foreign key references Items(ItemID),
ManagerID int foreign key references Manager(ManagerID)
primary key(ItemID, ManagerID)
)














