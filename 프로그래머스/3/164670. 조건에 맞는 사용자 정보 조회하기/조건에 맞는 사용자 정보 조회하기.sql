-- 코드를 입력하세요
SELECT u.user_id, u.nickname, concat(u.city,' ',u.STREET_ADDRESS1,' ',u.STREET_ADDRESS2) as 전체주소, concat(substr(u.tlno, 1, 3), '-', substr(u.tlno, 4, 4), '-', substr(u.tlno, 8, 4) )
from USED_GOODS_USER u 
inner join USED_GOODS_BOARD b 
on u.user_id = b.writer_id 
group by u.user_id 
having count(b.writer_id) >= 3
order by u.user_id desc;