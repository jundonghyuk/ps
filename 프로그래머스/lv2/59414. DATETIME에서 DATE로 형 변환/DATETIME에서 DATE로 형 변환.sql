-- 코드를 입력하세요
SELECT a.ANIMAL_ID, a.NAME, DATE_FORMAT(a.DATETIME, "%Y-%m-%d")
from ANIMAL_INS as a
ORDER BY 1
