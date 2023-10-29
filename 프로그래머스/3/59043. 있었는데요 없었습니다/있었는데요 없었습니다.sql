-- 코드를 입력하세요
SELECT i.animal_id, i.name
from animal_ins i 
inner join animal_outs o 
on i.animal_id = o.animal_id 
where timediff(i.datetime, o.datetime) > 0 
order by i.datetime asc;
