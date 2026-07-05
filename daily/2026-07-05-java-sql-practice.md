# 2026-07-05 - Java / SQL Practice

## Java Problem

- Number: 118
- Title: Pascal's Triangle
- Link: https://leetcode.com/problems/pascals-triangle/
- Difficulty: Easy
- Language: Java
- Attempt type: guided practice

## SQL Problem

- Number: 1251
- Title: Average Selling Price
- Link: https://leetcode.com/problems/average-selling-price/
- Difficulty: Easy
- Language: SQL
- Attempt type: guided practice

## Java Main Idea

Pascal's Triangle 的每一列都從 `1` 開始，也用 `1` 結束。

中間的數字不是自己猜出來的，而是由上一列的兩個位置加起來：

```text
上一列: [1, 3, 3, 1]
新一列: [1, 4, 6, 4, 1]

4 = 1 + 3
6 = 3 + 3
4 = 3 + 1
```

所以做法是從第 0 列開始，一列一列建立。遇到第一格或最後一格就放
`1`，其他格子就去上一列拿左上與右上的數字相加。

## Java Core Code

```java
for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
    List<Integer> currentRow = new ArrayList<>();

    for (int columnIndex = 0; columnIndex <= rowIndex; columnIndex++) {
        boolean isFirstColumn = columnIndex == 0;
        boolean isLastColumn = columnIndex == rowIndex;

        if (isFirstColumn || isLastColumn) {
            currentRow.add(1);
        } else {
            List<Integer> previousRow = triangle.get(rowIndex - 1);
            int leftParent = previousRow.get(columnIndex - 1);
            int rightParent = previousRow.get(columnIndex);
            currentRow.add(leftParent + rightParent);
        }
    }

    triangle.add(currentRow);
}
```

## Java Complexity

- Time: O(numRows^2)，因為總共要建立三角形裡的每一個數字。
- Space: O(numRows^2)，因為結果本身需要存下所有列。

## SQL Main Idea

平均售價不是直接平均 `price`，而是要算加權平均：

```text
average_price = 總收入 / 總銷售數量
              = SUM(price * units) / SUM(units)
```

`Prices` 是價格區間，`UnitsSold` 是實際銷售紀錄。要把銷售日期落在價格
區間內的資料接起來。

日期條件要放在 `ON` 裡面，因為題目要求沒有銷售紀錄的 product 也要出現。
如果把日期條件放到 `WHERE`，`LEFT JOIN` 之後的 `NULL` 銷售列會被過濾掉。

## SQL Core Query

```sql
SELECT
    p.product_id,
    IFNULL(ROUND(SUM(p.price * u.units) / SUM(u.units), 2), 0) AS average_price
FROM Prices p
LEFT JOIN UnitsSold u
ON p.product_id = u.product_id
AND u.purchase_date BETWEEN p.start_date AND p.end_date
GROUP BY p.product_id;
```

## SQL Concept

- `LEFT JOIN`: 保留沒有銷售紀錄的商品。
- `BETWEEN`: 檢查購買日期是否落在價格有效區間。
- `SUM(price * units) / SUM(units)`: 加權平均。
- `IFNULL(..., 0)`: 沒有銷售數量時，把 `NULL` 轉成 `0`。

## Mistakes To Avoid

- Java: 不要直接從目前列找中間數字，中間數字必須來自上一列。
- Java: 第一格和最後一格永遠是 `1`，不要去讀不存在的上一列位置。
- SQL: 不要用 `AVG(price)`，因為不同價格賣出的數量可能不同。
- SQL: 不要把日期區間條件放在 `WHERE`，否則沒有銷售紀錄的商品會被刪掉。
