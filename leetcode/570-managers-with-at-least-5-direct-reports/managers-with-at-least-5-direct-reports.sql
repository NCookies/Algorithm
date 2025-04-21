-- SELECT
--     name
-- FROM
--     Employee
-- WHERE
--     id IN (
--         SELECT managerId 
--         FROM Employee 
--         GROUP BY managerId 
--         HAVING COUNT(*) >= 5)

SELECT e.name
FROM Employee e
    INNER JOIN Employee m ON e.id = m.managerId
GROUP BY m.managerId
HAVING COUNT(*) >= 5