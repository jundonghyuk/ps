-- 코드를 입력하세요
SELECT b.writer_id, 
u.nickname ,
sum(b.price)
from USED_GOODS_BOARD b 
inner join USED_GOODS_USER u 
on b.writer_id = u.user_id 
where b.status = 'DONE' 
group by b.writer_id 
having sum(b.price) >= 700000 
order by 3 asc;