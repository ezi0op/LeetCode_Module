# Write your MySQL query statement below
select a.name as name ,sum(b.amount) as balance from users a join transactions b on a.account=b.account group by a.account,a.name having sum(b.amount)>10000;