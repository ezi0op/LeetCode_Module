# Write your MySQL query statement below
select name from salesperson where sales_id not in (select a.sales_id from orders a join company c on a.com_id = c.com_id where  c.name='RED');