# 2026-06-25 - Valid Palindrome

## Problem

- Number: 125
- Title: Valid Palindrome
- Link: https://leetcode.com/problems/valid-palindrome/
- Difficulty: Easy
- Language: Java
- Attempt type: reviewed with assistance

## Main Idea

這題要判斷字串在忽略大小寫、空白、標點符號之後，從前往後讀和從後往前讀是否一樣。

直覺做法是用兩個指針：

- `left` 從字串開頭往右走。
- `right` 從字串結尾往左走。
- 如果遇到不是英文字母或數字的字元，就跳過。
- 兩邊都停在有效字元後，把它們轉成小寫再比較。

例如：

```text
"A man, a plan, a canal: Panama"
```

忽略空白和標點後會變成：

```text
"amanaplanacanalpanama"
```

這個字串左右讀都一樣，所以答案是 `true`。

## Core Code

```java
while (left < right) {
    while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
        left++;
    }

    while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
        right--;
    }

    char leftChar = Character.toLowerCase(s.charAt(left));
    char rightChar = Character.toLowerCase(s.charAt(right));

    if (leftChar != rightChar) {
        return false;
    }

    left++;
    right--;
}

return true;
```

## Complexity

- Time: O(n)，每個字元最多被左右指針掃過一次。
- Space: O(1)，只使用固定數量的變數，沒有建立新的過濾後字串。

## Mistakes to Avoid

- 不要直接比較原字串，因為空白、逗號、冒號等符號都要忽略。
- 比較前要先轉成同一種大小寫，否則 `A` 和 `a` 會被當成不同字元。
- 跳過無效字元時，內層 `while` 也要檢查 `left < right`，避免指針交錯後還繼續取字元。
- 空字串或只包含空白、符號的字串，在這題定義下是 palindrome。
