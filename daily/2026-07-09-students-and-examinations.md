# 2026-07-09 - Students and Examinations

## Problem

- Number: 1280
- Title: Students and Examinations
- Link: https://leetcode.com/problems/students-and-examinations/
- Difficulty: Easy
- Language: SQL
- Attempt type: guided practice

## Main Idea

這題要列出「每一位學生」和「每一個科目」的所有組合，然後計算這位學生參加該科目考試幾次。

關鍵是：就算某個學生某個科目考了 `0` 次，也要出現在答案裡。

所以不能只從 `Examinations` 開始查，因為 `Examinations` 只記錄真的有考過的資料。沒有考過的組合不會在這張表裡。

做法分成兩步：

1. 用 `CROSS JOIN` 先產生所有「學生 x 科目」組合。
2. 用 `LEFT JOIN` 接上 `Examinations`，有考過就數次數，沒考過就保留為 0。

簡單例子：

```text
Students: Alice, Bob
Subjects: Math, English

CROSS JOIN 之後:
Alice - Math
Alice - English
Bob   - Math
Bob   - English
```

接著再去 `Examinations` 找每個組合出現幾次。

## Core Query

```sql
WITH all_student_subjects AS (
    SELECT
        s.student_id,
        s.student_name,
        sub.subject_name
    FROM Students s
    CROSS JOIN Subjects sub
)
SELECT
    pairs.student_id,
    pairs.student_name,
    pairs.subject_name,
    COUNT(e.subject_name) AS attended_exams
FROM all_student_subjects pairs
LEFT JOIN Examinations e
ON pairs.student_id = e.student_id
AND pairs.subject_name = e.subject_name
GROUP BY
    pairs.student_id,
    pairs.student_name,
    pairs.subject_name
ORDER BY
    pairs.student_id,
    pairs.subject_name;
```

## SQL Concept

- `WITH all_student_subjects AS (...)`: 先把「所有學生 x 所有科目」這個中間結果取一個清楚的名字。
- `CROSS JOIN`: 產生兩張表的所有組合，也就是每個學生配上每個科目。
- `LEFT JOIN`: 保留左邊已經產生好的所有組合，即使右邊沒有符合的考試紀錄。
- `COUNT(e.subject_name)`: 只計算有匹配到的考試紀錄；如果沒有考過，會得到 `0`。
- `GROUP BY`: 以學生和科目為單位統計考試次數。

## Mistakes to Avoid

- 不要只查 `Examinations`，否則沒考過的學生科目組合會消失。
- 不要用 `INNER JOIN` 接考試紀錄，因為 `0` 次的組合也會被排除。
- `COUNT(*)` 在這題容易算錯，因為 `LEFT JOIN` 沒匹配時仍然會保留一列；要數右表欄位，例如 `COUNT(e.subject_name)`。
- `ORDER BY` 要照題目要求使用 `student_id` 和 `subject_name`。
