-- 코드를 입력하세요
SELECT order_id, product_id, date_format(out_date,'%Y-%m-%d'), 
case  
when out_date is null then '출고미정' 
when date_format(out_date,'%m-%d') <= '05-01' then '출고완료' 
when date_format(out_date,'%m-%d') > '05-01' then '출고대기' 
end 
from food_order 
order by order_id asc;