-- LeetCode 1581: Customer Who Visited but Did Not Make Any Transactions
-- Problem: https://leetcode.com/problems/customer-who-visited-but-did-not-make-any-transactions/
--
-- Table: Visits
--
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | visit_id    | int     |
-- | customer_id | int     |
-- +-------------+---------+
--
-- Table: Transactions
--
-- +----------------+---------+
-- | Column Name    | Type    |
-- +----------------+---------+
-- | transaction_id | int     |
-- | visit_id       | int     |
-- | amount         | int     |
-- +----------------+---------+
--
-- Goal:
-- Return each customer who visited without making any transactions, and count
-- how many such visits they had.
--
-- Concept:
-- Use LEFT JOIN to keep every visit. If there is no matching transaction, the
-- transaction columns become NULL. Then GROUP BY customer_id to count those
-- no-transaction visits.

SELECT
    v.customer_id,
    COUNT(*) AS count_no_trans
FROM Visits v
LEFT JOIN Transactions t
ON v.visit_id = t.visit_id
WHERE t.transaction_id IS NULL
GROUP BY v.customer_id;
