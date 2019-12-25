# Write your MySQL query statement below
select w1.id
from Weather w1, Weather w2
where w1.RecordDate - interval 1 day = w2.RecordDate
    and w1.Temperature > w2.Temperature;
