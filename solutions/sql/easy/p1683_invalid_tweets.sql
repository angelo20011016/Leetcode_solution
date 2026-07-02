-- LeetCode 1683: Invalid Tweets
-- Problem: https://leetcode.com/problems/invalid-tweets/
--
-- Table: Tweets
--
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | tweet_id    | int     |
-- | content     | varchar |
-- +-------------+---------+
--
-- Goal:
-- 找出內容長度超過 15 個字元的推文，並回傳 tweet_id。
--
-- Concept:
-- CHAR_LENGTH 計算文字包含多少個字元，
-- WHERE 只保留字元數大於 15 的資料。

SELECT tweet_id
FROM Tweets
WHERE CHAR_LENGTH(content) > 15;
