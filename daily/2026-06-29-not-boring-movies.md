# 2026-06-29 - Not Boring Movies

## Problem

- Number: 620
- Title: Not Boring Movies
- Link: https://leetcode.com/problems/not-boring-movies/
- Difficulty: Easy
- Language: SQL
- Attempt type: reviewed with assistance

## Main Idea

這題要從 `Cinema` 表格中找出符合兩個條件的電影：

- `id` 是奇數
- `description` 不是 `boring`

最後還要按照 `rating` 從高到低排序。

可以把條件想成兩道篩選：

```text
先留下奇數 id 的電影
再排除 description = 'boring' 的電影
最後用 rating DESC 排序
```

## Core Query

```sql
SELECT
    id,
    movie,
    description,
    rating
FROM Cinema
WHERE MOD(id, 2) = 1
  AND description <> 'boring'
ORDER BY rating DESC;
```

## SQL Concept

- `MOD(id, 2) = 1`：判斷 `id` 除以 2 的餘數是不是 1，也就是奇數。
- `<>`：表示不等於。
- `AND`：兩個條件都要成立。
- `ORDER BY rating DESC`：按照評分由高到低排序。

## Mistakes to Avoid

- 不要只檢查 `description <> 'boring'`，題目還要求 `id` 必須是奇數。
- 不要把 `DESC` 忘掉，否則排序方向會變成預設的由小到大。
- `description = 'boring'` 是要排除的資料，不是要留下的資料。
- `MOD(id, 2) = 0` 代表偶數，這題要的是 `= 1`。
