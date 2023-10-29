-- 코드를 입력하세요
SELECT year(sales_date), month(sales_date), u.gender, count(distinct u.user_id)
from user_info u 
inner join online_sale o 
on u.user_id = o.user_id 
where u.gender is not null 
group by year(sales_date), month(sales_date), u.gender
order by 1 asc, 2 asc, 3 asc;