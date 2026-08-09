# 2026-08-08 - Find the Index of the First Occurrence in a String

## Problem

- Number: 28
- Title: Find the Index of the First Occurrence in a String
- Link: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
- Difficulty: Easy
- Language: Java
- Attempt type: reviewed with assistance

## Main Idea

要找的是 `needle` 第一次出現在 `haystack` 的起始位置。

可以把 `needle` 想成一張要比對的小卡片，從 `haystack` 的每一個可能起點開始，一個字元一個字元地比：

```text
haystack = "sadbutsad"
needle   = "sad"

從 index 0 開始比：s = s、a = a、d = d
全部相同，所以答案是 0。
```

不需要從最後幾個不可能容納完整 `needle` 的位置開始。例如 `haystack` 長度是 8、`needle` 長度是 3，最後可開始比對的位置是 `8 - 3 = 5`。

## Core Code

```java
int lastStartIndex = haystack.length() - needle.length();

for (int startIndex = 0; startIndex <= lastStartIndex; startIndex++) {
    int needleIndex = 0;

    while (needleIndex < needle.length()
            && haystack.charAt(startIndex + needleIndex) == needle.charAt(needleIndex)) {
        needleIndex++;
    }

    boolean foundCompleteNeedle = needleIndex == needle.length();
    if (foundCompleteNeedle) {
        return startIndex;
    }
}

return -1;
```

## Complexity

- Time: O(n × m)，`n` 是 `haystack` 長度、`m` 是 `needle` 長度；最壞情況下，每個起點都可能比對 `needle` 的所有字元。
- Space: O(1)，只使用幾個索引變數。

## Mistakes to Avoid

- 外層迴圈要用 `<= lastStartIndex`，最後一個合法起點也必須檢查。
- 不要讓 `startIndex + needleIndex` 超出 `haystack` 範圍；限制最後起點可以避免這個問題。
- 每次換新的起點時，`needleIndex` 都要重設為 `0`。
- `needle` 是空字串時，依題意應回傳 `0`。
