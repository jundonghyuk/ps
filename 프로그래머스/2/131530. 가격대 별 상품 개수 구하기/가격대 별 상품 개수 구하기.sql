select floor(price / 10000) * 10000, count(*)  
from product 
group by 1 
order by 1;