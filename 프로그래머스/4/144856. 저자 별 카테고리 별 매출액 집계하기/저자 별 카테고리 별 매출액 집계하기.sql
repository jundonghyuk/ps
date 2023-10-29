-- 코드를 입력하세요
SELECT a.author_id, a.author_name, b.category, sum(c.total * b.price)
from book b 
inner join author a 
on b.author_id = a.author_id 
inner join 
(select distinct book_id, sum(sales) total from book_sales where sales_date like '2022-01%' group by book_id ) c
on c.book_id = b.book_id 
group by a.author_id, b.category
order by 1 asc, 3 desc;
