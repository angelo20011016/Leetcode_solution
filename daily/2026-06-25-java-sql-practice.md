# 2026-06-25

## Java Problem

- Number: 83
- Title: Remove Duplicates from Sorted List
- Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
- Difficulty: Easy
- Language: Java
- Attempt type: guided practice

## SQL Problem

- Number: 584
- Title: Find Customer Referee
- Link: https://leetcode.com/problems/find-customer-referee/
- Difficulty: Easy
- Language: SQL
- Attempt type: guided practice

## Java Thinking

The linked list is already sorted, so duplicate values must be next to each
other.

Use one pointer:

- `current` starts at `head`.
- If `current.val == current.next.val`, skip the next node.
- Otherwise, move `current` forward.

When skipping a duplicate, do not move `current` yet. There may be more than one
duplicate in a row.

## Java Pattern

```java
ListNode current = head;

while (current != null && current.next != null) {
    if (current.val == current.next.val) {
        current.next = current.next.next;
    } else {
        current = current.next;
    }
}

return head;
```

For `1 -> 1 -> 2 -> 3 -> 3`:

```text
1 -> 1 -> 2 -> 3 -> 3
1 ------> 2 -> 3 -> 3
1 -> 2 -> 3 ------> null
```

The final list is:

```text
1 -> 2 -> 3
```

## SQL Thinking

We need customers who were not referred by customer `2`.

There are two valid cases:

- `referee_id` is not `2`.
- `referee_id` is `NULL`, meaning there is no referee.

Use `IS NULL` for `NULL` checks. A normal comparison like `referee_id <> 2`
does not include `NULL` rows.

## SQL Pattern

```sql
SELECT name
FROM Customer
WHERE referee_id IS NULL OR referee_id <> 2;
```

## Complexity

- Java time: O(n)
- Java space: O(1)
- SQL concept: filtering with `OR`, handling `NULL` with `IS NULL`

## Mistakes To Avoid

- Java: The list is sorted, so only adjacent nodes need to be compared.
- Java: After skipping a duplicate, keep `current` in the same place to catch
  repeated duplicates like `1 -> 1 -> 1`.
- SQL: Do not write only `referee_id <> 2`; that excludes `NULL` rows.
- SQL: Use `IS NULL`, not `= NULL`.
