# 2026-06-23

## Java Problem

- Number: 344
- Title: Reverse String
- Link: https://leetcode.com/problems/reverse-string/
- Difficulty: Easy
- Language: Java
- Attempt type: guided practice

## SQL Problem

- Number: 1683
- Title: Invalid Tweets
- Link: https://leetcode.com/problems/invalid-tweets/
- Difficulty: Easy
- Language: SQL
- Attempt type: guided practice

## Java Thinking

We need to reverse a character array in-place.

Use two pointers:

- `left` starts at index `0`
- `right` starts at index `s.length - 1`

Swap `s[left]` and `s[right]`, then move both pointers toward the middle.

## Java Pattern

```java
int left = 0;
int right = s.length - 1;

while (left < right) {
    char temp = s[left];
    s[left] = s[right];
    s[right] = temp;

    left++;
    right--;
}
```

For `['h', 'e', 'l', 'l', 'o']`:

```text
swap h and o -> o e l l h
swap e and l -> o l l e h
```

The middle character does not need to move.

## SQL Thinking

We need tweets where `content` is longer than 15 characters.

Use `CHAR_LENGTH(content)` to count characters, then filter with `WHERE`.

## SQL Pattern

```sql
SELECT tweet_id
FROM Tweets
WHERE CHAR_LENGTH(content) > 15;
```

## Complexity

- Java time: O(n)
- Java space: O(1)
- SQL concept: string length filtering with `CHAR_LENGTH`

## Mistakes To Avoid

- Java: Do not use a new array; the problem asks us to modify the input array.
- Java: Use `left < right`, not `left <= right`, because the middle character
  does not need to swap with itself.
- SQL: The condition is more than 15 characters, so use `> 15`, not `>= 15`.
