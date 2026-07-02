# 2026-06-21 — First Unique Character in a String

## Problem

- Number: 387
- Title: First Unique Character in a String
- Link: https://leetcode.com/problems/first-unique-character-in-a-string/
- Difficulty: Easy
- Language: Java
- Attempt type: reviewed with assistance

## Main Idea

我們需要知道每個字元出現幾次，也需要保留原本的字元順序。

先走訪字串一遍，用 `HashMap` 記錄「每個字元出現幾次」。
接著再從字串開頭走訪一次，第一個出現次數等於 1 的字元就是答案。

例如 `s = "loveleetcode"`：

- 統計後，`l` 和 `o` 都出現超過一次。
- 索引 2 的 `v` 只出現一次。
- 因此回傳 `2`。

## Core Code

```java
Map<Character, Integer> characterCounts = new HashMap<>();

for (int i = 0; i < s.length(); i++) {
    char currentCharacter = s.charAt(i);
    int currentCount = characterCounts.getOrDefault(currentCharacter, 0);
    characterCounts.put(currentCharacter, currentCount + 1);
}

for (int i = 0; i < s.length(); i++) {
    char currentCharacter = s.charAt(i);
    if (characterCounts.get(currentCharacter) == 1) {
        return i;
    }
}

return -1;
```

## Complexity

- Time: O(n)，字串最多走訪兩次。
- Space: O(k)，`k` 是不同字元的數量。

## Mistakes to Avoid

- 只統計次數，卻沒有按照原字串順序尋找答案。
- 回傳字元本身；題目要求的是字元的索引。
- 忘記在沒有唯一字元時回傳 `-1`。
- `getOrDefault(character, 0)` 的預設值不要寫成 1，否則第一次出現就會被計算成 2。
