-- 코드를 입력하세요
SELECT f.product_id, f.product_name, sum(o.amount) *f.price 
from food_product f 
inner join food_order o 
on f.product_id = o.product_id and o.produce_date like '2022-05%'
group by f.product_id
order by 3 desc, 1 asc;

