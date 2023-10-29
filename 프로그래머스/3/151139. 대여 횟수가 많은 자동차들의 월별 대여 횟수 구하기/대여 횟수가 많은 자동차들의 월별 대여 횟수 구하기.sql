-- 코드를 입력하세요
select month(start_date) MONTH, car_id CAR_ID, count(*) RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
where car_id 
in(
    SELECT distinct car_id 
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    where start_date >= '2022-08-01' and start_date <= '2022-10-31' 
    group by car_id 
    having count(*) >= 5)
and start_date >= '2022-08-01' and start_date <= '2022-10-31' 
group by car_id, month(start_date)
having count(*) > 0 
order by 1 asc, 2 desc;
