select m.member_name, w.review_text, date_format(w.review_date, '%Y-%m-%d')
from member_profile m
inner join rest_review w 
on m.member_id = w.member_id
where m.member_id in 
(select * from (select member_id from rest_review group by member_id order by count(review_id) desc limit 1) sub)
order by 3 asc, 2 asc;