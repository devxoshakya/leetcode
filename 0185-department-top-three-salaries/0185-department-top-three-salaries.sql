# Write your MySQL query statement below

Select Y.Employee, Y.Salary, Y.Department from
(
select X.*,
DENSE_RANK() OVER(PARTITION BY X.Department ORDER BY X.Salary DESC) as `rank`
From (select E.name as Employee, E.salary as Salary, D.name as Department
from Employee E JOIN Department D ON E.departmentId = D.id) X 
) Y

where Y.`rank` <= 3;