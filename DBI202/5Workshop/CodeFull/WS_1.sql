create database QLDiem
use QLDiem

create table Class(classCode varchar(10) primary key, headTeacher varchar(30),
room varchar(30), timeSlot varchar(30), closeDate datetime)

create table Student(rollNo varchar(10) primary key, 
classCode varchar(10) foreign key references Class(classCode),
fullName varchar(30), male bit, birthDate datetime, 
address varchar(30), province char(2), 
email varchar(30))

create table Subject(subjectCode varchar(10) primary key, subjectName varchar(40),
wTest bit, pTest bit, WTest_per smallint, pTest_per int)

create table Mark(subjectCode varchar(10)foreign key references Subject(subjectCode),
rollNo varchar(10) foreign key references Student(rollNo),
primary key(rollNo, subjectCode), 
wMark float(8), pMark float(8),
mark float(8))

-- insert Class
insert into Class values ('E123', 'NguyenDuy', 'class2, lab1', '7h30-12h30', getDate())
insert into Class values ('E125', 'NguyenL', 'class2, lab1', '7h30-12h30', getDate())
insert into Class values ('E125', 'NguyenL', 'class2, lab1', '7h30-12h30', getDate())
insert into Class values ('E124', 'NguyenThach', 'class1, lab2', '7h30-12h30', '2006/07/23')
insert into Class values ('E126', 'NguyenKhang', 'class2, lab1', '12h50-17h50', '2006/07/23')
select * from Class

-- insert Subject
insert into Subject values ('C', 'Programming with C', '1', '1', '40', '60')
insert into Subject values ('SQL1', 'SQL1', '1', '0', '100', '0')
insert into Subject values ('SQL2', 'SQL2', '1', '1', '40', '60')
select * from Subject

-- insert Student
insert into Student(rollNo, classCode, fullName, male, birthDate, address, province) 
values ('A01', 'E123', 'Nguyen A', '1', '11/23/1982', '65 Hoang Hoa Tham', 'HN')
insert into Student(rollNo, classCode, fullName, male, birthDate, province, email)
values ('A02', 'E123', 'Nguyen B', '1', '10/21/1982', 'HN', 'trongfpt.edu.vn')
insert into Student(rollNo, classCode, fullName, male, birthDate, address, province, email)
values ('A03', 'E123', 'Nguyen C', '1', '10/19/1983', '6 Tran Phu', 'HN', 'dung@fpt.edu.vn')
insert into Student(rollNo, classCode, fullName, male, birthDate, address, province)
values ('A04', 'E123', 'Nguyen D', '1', '11/10/1984', '3 Kim Ma', 'HN')
insert into Student(rollNo, classCode, fullName, male, birthDate, province)
values ('A05', 'E123', 'Nguyen E', '1', '9/11/1983', 'HP')
insert into Student(rollNo, classCode, fullName, male, birthDate, address, province)
values ('A06', 'E123', 'Nguyen Y', '0', '10/26/1986', '65 Hoang Hoa Tham', 'HN')
insert into Student(rollNo, classCode, fullName, male, birthDate, address, province, email)
values ('A07', 'E123', 'Nguyen F', '0', '11/01/1988', '65 Hoang Hoa Tham', 'HN', 'lannb@fpt.vn')
select * from Student

--ínsert Mark
insert into Mark values ('C','A01', '20', '10', '14')
insert into Mark values ('SQL1','A01',  '20', '0', '8')
insert into Mark values ('SQL2','A01', '18', '12', '18.2')
insert into Mark values ('C','A02', '20', '10', '14')
insert into Mark values ('SQL1','A02',  '23', '15', '14')
insert into Mark values ('SQL2','A02',  '23', '10', '18')
select * from Mark

--update class
update Class set headTeacher='NguyenThom' where headTeacher='NguyenDuy'
select * from Class

--delete Student
delete Student where rollNo='A06'
select * from Student

--1.1.1
alter table Student
add constraint FK_Student_ClassCode
foreign key (classCode) references Class(Code);

--1.1.2
select distinct fullName from Student
where email like '%@fpt.vn' or email like '%@fpt.com.vn'

--1.1.3
select * from Class
where closeDate = '2006/07/23'
and not exists ( select * from Student where Student.classCode = Class.classCode)

--1.1.4
delete Class, Student, Mark
left join Student on Class.classCode = Student.classCode
left join Mark on Student.rollNo = Mark.rollNo
where Class.closeDate < '2005/01/01'

--1.1.5
select classCode, rollNo, fullName, count (*) as totalStudent
from Student group by classCode, rollNo, fullName with ROLLUP

--1.1.6
CREATE VIEW viewClass1 AS
SELECT C.classCode, C.headTeacher, C.room, C.timeSlot, C.closeDate
FROM Class C
WHERE C.classCode IN (
    SELECT classCode
    FROM Student
    GROUP BY classCode
    HAVING COUNT(*) > 17
);
select * from viewCLass1

--1.1.7
SELECT subjectCode, subjectName, COUNT(*) AS SoSinhVien
FROM Subject
GROUP BY subjectCode, subjectName
HAVING COUNT(*) = (
    SELECT MAX(CountStudents)
    FROM (
        SELECT COUNT(*) AS CountStudents
        FROM Subject
        GROUP BY subjectCode, subjectName
    ) AS Subquery
)

--1.2.1
select count(*) as totalStudent from Mark
where subjectCode = 'C' 

--1.2.2
select subjectCode, count(*) as totalStudent from Mark
group by subjectCode
order by subjectCode asc

--1.2.3
select a.rollNo, a.province, b.subjectCode from Student as a join Mark as b on a.rollNo = b.rollNo
where b.mark < 10 and a.province = 'HT'
group by a.rollNo, a.province, b.subjectCode

--1.2.4
select classCode, count(*) as totalNumber from Student
group by classCode 

--1.2.5
SELECT Student.FullName, Subject.SubjectName
FROM Student
INNER JOIN Mark ON Student.rollNo = Mark.rollNo
INNER JOIN Subject ON Mark.SubjectCode = Subject.SubjectCode


--1.2.6
select a.rollNo, a.fullName, count(b.pMark) as timeTakeExam from Student as a join Mark as b on a.rollNo = b.rollNo
group by a.rollNo, a.fullName

--1.2.7
select a.rollNo, a.province, AVG(b.mark) as average from Student as a join Mark as b on a.rollNo = b.rollNo
group by a.rollNo, a.province
order by average desc

--1.2.8
select a.rollNo, a.fullName from Student as a join Mark as b on a.rollNo = b.rollNo
group by a.rollNo, a.fullName
having AVG(b.Mark)>15
