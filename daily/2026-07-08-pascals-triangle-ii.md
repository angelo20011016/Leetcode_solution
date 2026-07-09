# 2026-07-08 - Pascal's Triangle II

## Problem

- Number: 119
- Title: Pascal's Triangle II
- Link: https://leetcode.com/problems/pascals-triangle-ii/
- Difficulty: Easy
- Language: Java
- Attempt type: guided practice

## Main Idea

這題要回傳 Pascal's Triangle 的第 `rowIndex` 列，而且 `rowIndex` 從 0 開始。

直覺做法是先建立整個三角形，再拿最後一列。不過這題只需要一列，所以可以只保留目前這一列：

```text
rowIndex = 4

第 0 列: [1]
第 1 列: [1, 1]
第 2 列: [1, 2, 1]
第 3 列: [1, 3, 3, 1]
第 4 列: [1, 4, 6, 4, 1]
```

每一列的第一個和最後一個數字都是 `1`。中間的數字來自上一列的左上方和右上方相加。

重點是：如果只用同一個 `List`，更新中間數字時要從右往左。這樣左邊的舊數字還沒有被改掉，才能正確當作上一列的數字使用。

## Core Code

```java
for (int currentRowIndex = 0; currentRowIndex <= rowIndex; currentRowIndex++) {
    row.add(1);

    for (int columnIndex = currentRowIndex - 1; columnIndex > 0; columnIndex--) {
        int leftParent = row.get(columnIndex - 1);
        int rightParent = row.get(columnIndex);
        int newValue = leftParent + rightParent;

        row.set(columnIndex, newValue);
    }
}
```

## Complexity

- Time: O(rowIndex^2)，因為要一列一列建立，每列會更新部分中間數字。
- Space: O(rowIndex)，只保留答案那一列，沒有建立整個三角形。

## Mistakes to Avoid

- 不要從左往右更新同一個 `List`，這會把還需要使用的上一列數字提早覆蓋掉。
- `rowIndex` 是從 0 開始，所以 `rowIndex = 0` 要回傳 `[1]`。
- 內層迴圈只更新中間數字，第一個和最後一個 `1` 不需要改。
