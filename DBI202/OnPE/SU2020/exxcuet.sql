--7
select p.productCode, p.productName, p.productCategory, 
count(o2.productCode) numberOfOrders, count(distinct c.customerNumber) numbersOfCustomers, 
sum(o2.quantityOrdered) totalQuantityOrdered, sum((o2.priceEach - p.buyPrice) * o2.quantityOrdered) totalProfits
from products p, orders o1, orderdetails o2, customers c
where p.productCode = o2.productCode and o2.orderNumber = o1.orderNumber and c.customerNumber = o1.customerNumber
and p.productCategory = 'Planes'
group by p.productCode, p.productName, p.productCategory
order by totalProfits desc
--2
select * from customers
where [state] = 'CA'
--3
select o.orderNumber, p.productCode, o.quantityOrdered, o.priceEach from products p, orderdetails o
where p.productCode = o.productCode and p.productCode = 'S18_1749' and o.quantityOrdered > 25
order by o.priceEach asc,o.quantityOrdered desc
--4
select o1.orderNumber, o1.orderDate, o1.requiredDate, o1.shippedDate, 
o1.status, c.customerNumber, c.customerName, c.city, c.country from customers c join orders o1
on c.customerNumber = o1.customerNumber
where o1.shippedDate is null and c.country = 'USA'
order by c.customerName asc
--5
select c.customerNumber, c.customerName, c.city, c.country, sum(p.amount) totalAmountOfPayments from customers c 
left join payments p on c.customerNumber = p.customerNumber
where c.country = 'Germany'
group by c.customerNumber, c.customerName, c.city, c.country
order by totalAmountOfPayments asc
--6
select e.employeeNumber, e.lastName, e.firstName, e.email, e.officeCode, e.reportsTo, e.jobTitle from employees e
left join customers c on c.salesRepEmployeeNumber = e.employeeNumber
where e.employeeNumber in (select e.employeeNumber from employees e
left join customers c on c.salesRepEmployeeNumber = e.employeeNumber
where c.salesRepEmployeeNumber is null)
--9
drop trigger tr_insertPayment
create trigger tr_insertPayment
on payments after insert
as
begin
	select i.customerNumber, c.customerName, i.checkNumber, i.paymentDate, i.amount from inserted i
	join customers c on c.customerNumber = i.customerNumber
	order by i.customerNumber desc
end
--10
delete from products 
where productCode not in (select o.productCode from orderdetails o )

	
















