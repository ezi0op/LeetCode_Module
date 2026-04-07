# Write your MySQL query statement below
select class from Courses Group by class HAVING COUNT(student) >= 5;