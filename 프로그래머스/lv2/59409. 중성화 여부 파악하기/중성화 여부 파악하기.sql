-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME, CASE WHEN SEX_UPON_INTAKE like "%Neutered%" or SEX_UPON_INTAKE like "%Spayed%" then 'O' else 'X' end as 중성화
from ANIMAL_INS
order by 1