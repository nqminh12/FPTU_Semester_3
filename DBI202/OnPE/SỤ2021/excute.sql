use PE_DBI202_Su2021
-- cau 2
select p.product_id, p.product_name, p.model_year, p.list_price, p.brand_name, p.category_name from products p
where p.category_name like 'Cyclocross Bicycles'
-- cau 3
select p.product_name, p.model_year, p.list_price, p.brand_name from products p
where p.brand_name like 'Trek' and p.model_year = 2018 and p.list_price > 3000
order by p.list_price asc
-- cau 4
select o.order_id, o.order_date, o.customer_id, s.first_name, s.last_name, st.store_name from orders o, staffs s, stores st
where o.staff_id = s.staff_id and s.store_id = st.store_id and year(o.order_date) = 2016 and month(o.order_date) = 1 
and st.store_name like 'Santa Cruz Bikes'
-- cau 5
select s.store_id, s.store_name, count(*) NumberOfOrdersIn2018 from orders o, stores s
where o.store_id = s.store_id and year(o.order_date) = 2018
group by s.store_id, s.store_name
order by NumberOfOrdersIn2018 desc
-- cau 6 
select p.product_id, p.product_name, p.model_year, sum(s.quantity) TotalStockQuantity from products p, stocks s
where p.product_id = s.product_id
group by p.product_id, p.product_name, p.model_year
having sum(s.quantity) = (select top 1 sum(s.quantity) TotalStockQuantity from products p, stocks s
where p.product_id = s.product_id
group by p.product_id
order by TotalStockQuantity desc)
-- cau 7
select b.store_name, b.staff_id, b.first_name, b.last_name, b.store_name, b.NumberOfOrders from (select s.store_name,st.staff_id, st.first_name, st.last_name, count(o.order_id) NumberOfOrders from stores s, staffs st, orders o
where o.staff_id = st.staff_id and o.store_id = s.store_id
group by s.store_name,st.staff_id, st.first_name, st.last_name) as b
join (select c.store_name,max(c.NumberOfOrders) as ccc from (select s.store_name,st.staff_id, st.first_name, st.last_name, count(o.order_id) NumberOfOrders from stores s, staffs st, orders o
where o.staff_id = st.staff_id and o.store_id = s.store_id
group by s.store_name,st.staff_id, st.first_name, st.last_name) as c
group by c.store_name) as bb
on b.store_name = bb.store_name and b.NumberOfOrders = bb.ccc
order by b.store_name
-- cau 8
create proc pr1
@store_id int, @numberOfStaffs int output
as
begin
	set @numberOfStaffs = (select count(*) from stores s, staffs st
where s.store_id = st.store_id and s.store_id = @store_id
group by s.store_id)
end

-- cau 9
create trigger Tr2
on stocks after delete
as
begin
select p.product_id, p.product_name, s.store_id, s.store_name, st.quantity  from deleted st, products p, stores s
where p.product_id = st.product_id and s.store_id = st.store_id 
end

-- cau 10
update stocks set quantity = 30 where product_id in (select st.product_id  from stocks st, products p
where p.product_id = st.product_id and p.category_name like 'Cruisers Bicycles'
) and store_id = 1
