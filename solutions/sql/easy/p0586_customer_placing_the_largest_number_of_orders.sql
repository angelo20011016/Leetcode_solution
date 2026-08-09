-- LeetCode 586: Customer Placing the Largest Number of Orders
-- Problem: https://leetcode.com/problems/customer-placing-the-largest-number-of-orders/
--
-- Table: Orders
--
-- +-----------------+----------+
-- | Column Name     | Type     |
-- +-----------------+----------+
-- | order_number    | int      |
-- | customer_number | int      |
-- +-----------------+----------+
--
-- Goal:
-- Return the customer_number for the customer who placed the largest number of
-- orders.
--
-- Concept:
-- GROUP BY customer_number, count each customer's rows, sort by that count from
-- highest to lowest, and keep only the first row.

SELECT customer_number
FROM Orders
GROUP BY customer_number
ORDER BY COUNT(*) DESC
LIMIT 1;
