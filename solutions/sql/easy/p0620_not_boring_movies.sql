-- LeetCode 620: Not Boring Movies
-- Problem: https://leetcode.com/problems/not-boring-movies/
--
-- Table: Cinema
--
-- +-------------+----------+
-- | Column Name | Type     |
-- +-------------+----------+
-- | id          | int      |
-- | movie       | varchar  |
-- | description | varchar  |
-- | rating      | float    |
-- +-------------+----------+
--
-- Goal:
-- Return movies with an odd id and a description that is not "boring".
-- Sort the result by rating from highest to lowest.
--
-- Concept:
-- Use MOD(id, 2) = 1 to keep odd ids, then use <> to exclude boring movies.

SELECT
    id,
    movie,
    description,
    rating
FROM Cinema
WHERE MOD(id, 2) = 1
  AND description <> 'boring'
ORDER BY rating DESC;
