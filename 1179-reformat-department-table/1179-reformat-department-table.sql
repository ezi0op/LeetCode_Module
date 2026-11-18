# Write your MySQL query statement below
select id , Max(case when month='jan' then revenue end) as Jan_Revenue,

Max(case when month='Feb' then revenue end) as Feb_Revenue 
,Max(case when month='Mar' then revenue end) as Mar_Revenue 
,
Max(case when month='Apr' then revenue end) as Apr_Revenue 
,
Max(case when month='May' then revenue end) as May_Revenue ,
Max(case when month='Jun' then revenue end) as Jun_Revenue 
,Max(case when month='Jul' then revenue end) as Jul_Revenue ,
Max(case when month='Aug' then revenue end) as Aug_Revenue ,
Max(case when month='Sep' then revenue end) as Sep_Revenue ,
Max(case when month='Oct' then revenue end) as Oct_Revenue 
,Max(case when month='Nov' then revenue end) as Nov_Revenue 
,Max(case when month='Dec' then revenue end) as Dec_Revenue 




 from department group by id;