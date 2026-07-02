# 2026-07-02 - Squares of a Sorted Array

## Problem

- Number: 977
- Title: Squares of a Sorted Array
- Link: https://leetcode.com/problems/squares-of-a-sorted-array/
- Difficulty: Easy
- Language: Java
- Attempt type: reviewed with assistance

## Main Idea

題目給的是已排序陣列，但裡面可能有負數。

平方之後，負數會變正數，所以原本最小的負數可能反而變成最大的平方數。

例如：

```text
nums = [-4, -1, 0, 3, 10]
平方後 = [16, 1, 0, 9, 100]
排序後 = [0, 1, 9, 16, 100]
```

因為陣列已經從小到大排序，最大的平方數一定會出現在兩端其中一邊：

- 左邊可能是很大的負數，例如 `-4`
- 右邊可能是很大的正數，例如 `10`

所以可以用雙指標比較左右兩端的平方，把比較大的平方放到答案陣列的最後面。

## Core Code

```java
int left = 0;
int right = nums.length - 1;
int writeIndex = nums.length - 1;

while (left <= right) {
    int leftSquare = nums[left] * nums[left];
    int rightSquare = nums[right] * nums[right];

    if (leftSquare > rightSquare) {
        result[writeIndex] = leftSquare;
        left++;
    } else {
        result[writeIndex] = rightSquare;
        right--;
    }

    writeIndex--;
}
```

## Complexity

- Time: O(n)，每個元素只會被左指標或右指標處理一次。
- Space: O(n)，需要一個新的陣列存放排序後的平方數。

## Mistakes to Avoid

- 不要直接原地平方後就以為仍然有排序，因為負數平方後可能變很大。
- `writeIndex` 要從最後一格開始寫，因為我們每次找到的是目前最大的平方數。
- 比較後記得移動對應的指標，否則會一直重複處理同一個數字。
- 迴圈條件要用 `left <= right`，這樣中間最後一個元素也會被放進答案。
