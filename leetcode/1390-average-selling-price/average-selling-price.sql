SELECT
    p.product_id,
    IFNULL(ROUND(SUM(u.units * p.price) / SUM(u.units), 2), 0) AS average_price
FROM
    Prices p
    LEFT JOIN UnitsSold u
        ON u.product_id = p.product_id 
        AND (u.purchase_date BETWEEN start_date AND end_date)
GROUP BY p.product_id