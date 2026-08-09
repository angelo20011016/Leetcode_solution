# 2026-07-06 - Java / SQL Practice

## Java Problem

- Number: 58
- Title: Length of Last Word
- Link: https://leetcode.com/problems/length-of-last-word/
- Difficulty: Easy
- Language: Java
- Attempt type: guided practice

## SQL Problem

- Number: 1581
- Title: Customer Who Visited but Did Not Make Any Transactions
- Link: https://leetcode.com/problems/customer-who-visited-but-did-not-make-any-transactions/
- Difficulty: Easy
- Language: SQL
- Attempt type: guided practice

## Java Main Idea

題目要找「最後一個單字」的長度。重點是字串最後面可能有空白，所以不能直接從最後一個字元開始數。

可以把流程拆成兩步：

1. 從右邊開始，先跳過尾端空白。
2. 遇到最後一個單字後，繼續往左數，直到遇到空白或超出字串開頭。

例子：

```text
"   fly me   to   the moon  "
                           ^
先跳過最後兩個空白

"   fly me   to   the moon  "
                       ^^^^
接著數 moon，長度是 4
```

## Java Core Code

```java
int index = s.length() - 1;

while (index >= 0) {
    boolean currentCharIsSpace = s.charAt(index) == ' ';
    if (!currentCharIsSpace) {
        break;
    }
    index--;
}

int length = 0;

while (index >= 0) {
    boolean currentCharIsSpace = s.charAt(index) == ' ';
    if (currentCharIsSpace) {
        break;
    }

    length++;
    index--;
}
```

## Java Complexity

- Time: O(n)，最差情況下會從右往左看完整個字串。
- Space: O(1)，只使用固定數量的變數。

## SQL Main Idea

題目要找「有拜訪，但是沒有交易」的紀錄，並依照 customer_id 統計次數。

`Visits` 是主表，因為每一次拜訪都要先保留下來。用 `LEFT JOIN` 接上 `Transactions` 後：

- 有交易的拜訪會接到 transaction 資料。
- 沒交易的拜訪，transaction 欄位會是 `NULL`。

所以只要留下 `t.transaction_id IS NULL` 的列，再用 `GROUP BY` 按顧客統計即可。

## SQL Core Query

```sql
SELECT
    v.customer_id,
    COUNT(*) AS count_no_trans
FROM Visits v
LEFT JOIN Transactions t
ON v.visit_id = t.visit_id
WHERE t.transaction_id IS NULL
GROUP BY v.customer_id;
```

## SQL Concept

- `LEFT JOIN`: 保留左表所有拜訪紀錄，即使右表沒有交易資料。
- `IS NULL`: 找出沒有成功配對到交易的拜訪。
- `GROUP BY`: 把同一位 customer 的無交易拜訪合在一起。
- `COUNT(*)`: 計算每位 customer 有幾次無交易拜訪。

## Mistakes To Avoid

- Java: 不要忘記先跳過字串尾端的空白，否則 `"Hello World  "` 會算成 0。
- Java: 迴圈裡要先檢查 `index >= 0`，避免字串全是空白時讀到非法位置。
- SQL: 不要用 `INNER JOIN`，因為沒有交易的拜訪會被直接丟掉。
- SQL: `WHERE t.transaction_id IS NULL` 要放在 join 之後，用來篩出沒有交易的拜訪。

## Additional SQL Problem

- Number: 586
- Title: Customer Placing the Largest Number of Orders
- Link: https://leetcode.com/problems/customer-placing-the-largest-number-of-orders/
- Difficulty: Easy
- Language: SQL
- Attempt type: light practice

### Main Idea

把同一位客戶的訂單分成一組，用 `COUNT(*)` 算每組訂單數；訂單數最多的客戶排在最前面，只取第一筆。

### Core Query

```sql
SELECT customer_number
FROM Orders
GROUP BY customer_number
ORDER BY COUNT(*) DESC
LIMIT 1;
```

### SQL Concept and Mistakes to Avoid

- `GROUP BY customer_number`：把同一位客戶的訂單放在同一組。
- `ORDER BY COUNT(*) DESC`：訂單數最多的客戶要排第一。
- `LIMIT 1`：只回傳第一名的客戶編號。
