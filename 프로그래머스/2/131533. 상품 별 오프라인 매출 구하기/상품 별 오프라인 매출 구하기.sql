SELECT P.PRODUCT_CODE, SUM(P.PRICE * OS.SALES_AMOUNT) AS "SALES"
FROM PRODUCT P
INNER JOIN OFFLINE_SALE OS ON P.PRODUCT_ID = OS.PRODUCT_ID
GROUP BY 1
ORDER BY 2 DESC, PRODUCT_CODE