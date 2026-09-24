# Write your MySQL query statement below
select a.product_name,c.year,c.price from Sales  c join Product a on a.product_id =  c.product_id;