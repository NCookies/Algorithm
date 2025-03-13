WITH TBL AS (
    SELECT 
        FP.PRODUCT_ID, 
        FP.PRODUCT_NAME, 
        FP.PRICE, 
        FO.AMOUNT,
        FP.PRICE * FO.AMOUNT AS SALES
    FROM FOOD_PRODUCT FP
    INNER JOIN FOOD_ORDER FO ON FP.PRODUCT_ID = FO.PRODUCT_ID
    WHERE DATE_FORMAT(FO.PRODUCE_DATE, "%Y-%m") = "2022-05"
)

SELECT PRODUCT_ID, PRODUCT_NAME, SUM(SALES) AS TOTAL_SALES
FROM TBL
GROUP BY PRODUCT_ID
ORDER BY TOTAL_SALES DESC, PRODUCT_ID