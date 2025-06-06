# 2021년에 가입한 전체 회원들 
# 상품을 구매한 회원수와 상품을 구매한 회원의 비율(=2021년에 가입한 회원 중 상품을 구매한 회원수 / 2021년에 가입한 전체 회원 수)
WITH CTE AS (
    SELECT COUNT(*) AS USER_COUNT
    FROM USER_INFO
    WHERE YEAR(JOINED) = 2021
)

SELECT 
    YEAR(S.SALES_DATE) AS YEAR,
    MONTH(S.SALES_DATE) AS MONTH,
    COUNT(DISTINCT S.USER_ID) AS PURCHASED_USERS,
    ROUND(COUNT(DISTINCT S.USER_ID) / USER_COUNT, 1) AS PUCHASED_RATIO
FROM
    ONLINE_SALE S, CTE
WHERE
    USER_ID IN (
        SELECT USER_ID
        FROM USER_INFO
        WHERE YEAR(JOINED) = 2021
    )
GROUP BY
    1, 2
ORDER BY
    1, 2