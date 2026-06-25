# 2026-06-14

## Java Problems

### 27. Remove Element

- Link: https://leetcode.com/problems/remove-element/
- Difficulty: Easy
- Language: Java
- Attempt type: guided practice

### 234. Palindrome Linked List

- Link: https://leetcode.com/problems/palindrome-linked-list/
- Difficulty: Easy
- Language: Java
- Attempt type: guided practice

## SQL Problems

### 610. Triangle Judgement

- Link: https://leetcode.com/problems/triangle-judgement/
- Difficulty: Easy
- Language: SQL
- Attempt type: guided practice

### 1757. Recyclable and Low Fat Products

- Link: https://leetcode.com/problems/recyclable-and-low-fat-products/
- Difficulty: Easy
- Language: SQL
- Attempt type: guided practice

## Java Thinking

### Remove Element

這題跟昨天的「把答案寫回陣列前面」很像。

差別是昨天要跳過重複值，今天要跳過指定的 `val`。

用兩個 index：

- `readIndex`：每一格都讀過，看目前數字是多少
- `writeIndex`：下一個要保留的數字要放的位置

如果 `nums[readIndex] == val`，代表這個數字要刪掉，所以什麼都不寫。
`readIndex` 還是會因為 `for` 迴圈繼續往右走。

如果 `nums[readIndex] != val`，代表這個數字要留下，就把它放到
`nums[writeIndex]`，然後 `writeIndex++`。

例如 `nums = [3, 2, 2, 3]`，`val = 3`：

- 看到第一個 `3`：要刪掉，跳過
- 看到 `2`：要留下，寫到第 0 格
- 看到第二個 `2`：要留下，寫到第 1 格
- 看到最後的 `3`：要刪掉，跳過

最後回傳 `2`，代表前兩格 `[2, 2]` 是答案。

### Palindrome Linked List

We need to check whether a linked list reads the same forward and backward.

The efficient linked-list pattern is:

1. Use `slow` and `fast` pointers to find the middle.
2. Reverse the second half of the list.
3. Compare the first half with the reversed second half.

For odd-length lists, `slow` lands on the middle node. Including that middle node
in the reversed second half is still fine because the middle value compares with
itself.

## Java Patterns

### Remove Element

```java
int writeIndex = 0;

for (int readIndex = 0; readIndex < nums.length; readIndex++) {
    if (nums[readIndex] != val) {
        nums[writeIndex] = nums[readIndex];
        writeIndex++;
    }
}

return writeIndex;
```

### Palindrome Linked List

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}

ListNode secondHalf = reverseList(slow);
ListNode firstHalf = head;

while (secondHalf != null) {
    if (firstHalf.val != secondHalf.val) {
        return false;
    }

    firstHalf = firstHalf.next;
    secondHalf = secondHalf.next;
}

return true;
```

## SQL Thinking

### Triangle Judgement

三條邊要能組成三角形，任兩邊相加都要大於第三邊。

所以要同時滿足：

- `x + y > z`
- `x + z > y`
- `y + z > x`

只要其中一個不成立，就不能組成三角形。

SQL 裡可以用 `CASE` 做判斷：

- 條件成立時回傳 `'Yes'`
- 否則回傳 `'No'`

### Recyclable and Low Fat Products

We only need rows where both flags are `Y`.

Because both conditions must be true, use `AND`, not `OR`.

## SQL Patterns

### Triangle Judgement

```sql
SELECT
    x,
    y,
    z,
    CASE
        WHEN x + y > z AND x + z > y AND y + z > x THEN 'Yes'
        ELSE 'No'
    END AS triangle
FROM Triangle;
```

### Recyclable and Low Fat Products

```sql
SELECT product_id
FROM Products
WHERE low_fats = 'Y' AND recyclable = 'Y';
```

## Complexity

- Remove Element time: O(n)
- Remove Element space: O(1)
- Palindrome Linked List time: O(n)
- Palindrome Linked List space: O(1)
- SQL concept: `CASE`, triangle inequality, `WHERE`, and `AND`

## Mistakes To Avoid

- Java: 相等於 `val` 的數字是跳過，不是把它設成 0。
- Java: 不管有沒有寫入，`readIndex` 都會繼續往右走。
- Java: 回傳的是保留下來的元素數量 `k`，不是被刪掉的數量。
- Java: Do not compare node references; compare `val`.
- Java: Save `nextNode` before changing `current.next` while reversing.
- SQL: 三個不等式都要成立，所以要用 `AND`。
- SQL: 條件要是大於 `>`，不是大於等於 `>=`。
- SQL: Do not use `OR`, because that would include products that satisfy only one condition.
