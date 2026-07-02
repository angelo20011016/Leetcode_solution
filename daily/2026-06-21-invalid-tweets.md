# 2026-06-21 — Invalid Tweets

## Problem

- Number: 1683
- Title: Invalid Tweets
- Link: https://leetcode.com/problems/invalid-tweets/
- Difficulty: Easy
- Language: SQL
- Attempt type: reviewed with assistance

## Main Idea

題目把內容超過 15 個字元的推文視為無效推文。

我們只需要：

1. 使用 `CHAR_LENGTH(content)` 計算推文的字元數。
2. 使用 `WHERE` 留下字元數大於 15 的推文。
3. 使用 `SELECT tweet_id` 回傳符合條件的推文編號。

例如：

| tweet_id | content | 字元數 | 是否回傳 |
| ---: | --- | ---: | --- |
| 1 | `Hello` | 5 | 否 |
| 2 | `This tweet is too long` | 22 | 是 |

## Final Query

```sql
SELECT tweet_id
FROM Tweets
WHERE CHAR_LENGTH(content) > 15;
```

## SQL Concept

- `CHAR_LENGTH(content)`：計算 `content` 有多少個字元。
- `WHERE`：只留下符合條件的資料列。
- `> 15`：必須超過 15；剛好 15 不算無效。

## Mistakes to Avoid

- 寫成 `>= 15`；題目要求的是超過 15。
- 回傳 `content`；題目要求回傳 `tweet_id`。
- 忘記將長度條件放在 `WHERE` 後面。
