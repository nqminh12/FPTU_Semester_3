use PE_DBI202_F2020
--cau2
select * from ranking_criteria
--cau3
select * from ranking_criteria r
where r.ranking_system_id in (1,2)
order by  r.ranking_system_id ASC, r.criteria_name ASC
--cau4
select u1.university_id, u2.university_name, u1.year, u1.num_students, u1.pct_international_students, u2.country_id from university_year u1, university u2
where u1.university_id = u2.id and u1.pct_international_students > 30 and u1.year = 2016
order by u2.university_name asc
--cau5
	select r2.ranking_system_id, r1.system_name ,count(*) numberOfCriteria from ranking_system r1, ranking_criteria r2 
	where r1.id = r2.ranking_system_id
	group by r2.ranking_system_id, r1.system_name
	order by numberOfCriteria desc
--cau 6
select u2.university_id, u1.university_name, u2.year, u2.student_staff_ratio from university u1, university_year u2
where u1.id = u2.university_id and u2.year = 2015 and u2.student_staff_ratio = (select min(u3.student_staff_ratio) from university_year u3
where u3.year = 2015)
--cau7
select c.university_id, c.university_name, c.ranking_system_id, c.criteria_name, c.year, c.score 
from (select u1.university_id, u.university_name, r.ranking_system_id, r.criteria_name, u1.year, u1.score 
from university u
join university_ranking_year u1 on u1.university_id = u.id
join ranking_criteria r on r.id = u1.ranking_criteria_id
where u1.year = 2016 and r.criteria_name like 'Teaching') as c
join 
(select u1.university_id, u.university_name, r.ranking_system_id, r.criteria_name, u1.year, u1.score 
from university u
join university_ranking_year u1 on u1.university_id = u.id
join ranking_criteria r on r.id = u1.ranking_criteria_id
where u1.year = 2016 and r.criteria_name like 'Teaching') as c1 on c.score = c1.score
group by  c.university_id, c.university_name, c.ranking_system_id, c.criteria_name, c.year, c.score
having count(c.score) > 1
-- cau 8 
create proc proc_university_year 
 @year int, @pct_international_students int, @nbUniversity int output
as
begin 
	set @nbUniversity = (select count(*) from university u, university_year u1
where u.id = u1.university_id and u1.year = @year and u1.pct_international_students	> @pct_international_students )

end
--cau9
create trigger tr_insert_university_ranking
on university_ranking_year after insert
as
begin
	select i.university_id, u.university_name, i.ranking_criteria_id, r.criteria_name, i.year, i.score from inserted i, university u, ranking_criteria r where i.university_id = u.id and r.id = i.ranking_criteria_id
end

insert into university_ranking_year(university_id, ranking_criteria_id, year, score)
values (1,1,2020,99), (12,2,2020,67)

-- cau 10 

insert into ranking_system values(4,'QS World University Ranking')

insert into ranking_criteria values(22,4,'Academic Reputation'), (23,4,'Citations per faculty')















































