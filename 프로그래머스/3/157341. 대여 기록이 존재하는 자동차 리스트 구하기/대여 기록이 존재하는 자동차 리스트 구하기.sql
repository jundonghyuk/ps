-- 코드를 입력하세요
SELECT c.car_id 
from CAR_RENTAL_COMPANY_CAR c 
inner join CAR_RENTAL_COMPANY_RENTAL_HISTORY h
on c.car_id = h.car_id 
where c.car_type = '세단' and h.start_date like '2022-10%' 
group by c.car_id 
order by c.car_id desc;