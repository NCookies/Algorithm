WITH TBL AS (
    SELECT CART_ID, GROUP_CONCAT(DISTINCT NAME) AS PRODUCTS
    FROM CART_PRODUCTS
    GROUP BY CART_ID
)

SELECT CART_ID
FROM TBL
WHERE PRODUCTS LIKE "%Milk%" AND PRODUCTS LIKE "%Yogurt%"
ORDER BY CART_ID
