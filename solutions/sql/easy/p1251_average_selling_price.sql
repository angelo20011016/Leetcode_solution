-- LeetCode 1251: Average Selling Price
-- Problem: https://leetcode.com/problems/average-selling-price/
--
-- Table: Prices
--
-- +---------------+---------+
-- | Column Name   | Type    |
-- +---------------+---------+
-- | product_id    | int     |
-- | start_date    | date    |
-- | end_date      | date    |
-- | price         | int     |
-- +---------------+---------+
--
-- Table: UnitsSold
--
-- +---------------+---------+
-- | Column Name   | Type    |
-- +---------------+---------+
-- | product_id    | int     |
-- | purchase_date | date    |
-- | units         | int     |
-- +---------------+---------+
--
-- Goal:
-- Return each product's average selling price, rounded to 2 decimal places.
-- If a product has no sold units, return 0 for its average price.
--
-- Concept:
-- Use LEFT JOIN so products without sales stay in the result. Put the date
-- range condition in the ON clause so missing sales do not disappear.

SELECT
    p.product_id,
    IFNULL(ROUND(SUM(p.price * u.units) / SUM(u.units), 2), 0) AS average_price
FROM Prices p
LEFT JOIN UnitsSold u
ON p.product_id = u.product_id
AND u.purchase_date BETWEEN p.start_date AND p.end_date
GROUP BY p.product_id;
