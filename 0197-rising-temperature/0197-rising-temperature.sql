# Write your MySQL query statement below
SELECT W.id 
From Weather W
cross join
Weather V
where DATEDIFF(W.recordDate,V.recordDate) = 1 AND W.temperature > V.temperature;