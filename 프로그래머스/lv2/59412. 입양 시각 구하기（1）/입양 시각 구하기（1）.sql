-- 코드를 입력하세요
SELECT  HOUR(DATETIME) as HOUR, count(DATE_FORMAT(DATETIME, "%h")) as COUNT
FROM ANIMAL_OUTS
WHERE HOUR(DATETIME) >= 9 and HOUR(DATETIME) < 20
GROUP BY DATE_FORMAT(DATETIME, "%h")
ORDEr by 1