-- 코드를 입력하세요
SELECT f.flavor 
from first_half f
inner join (select distinct flavor, sum(total_order) total_sum from july group by flavor) j
on f.flavor = j.flavor
order by f.total_order + j.total_sum desc 
limit 3;
