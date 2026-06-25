# 2026-06-24

## Java Problem

- Number: 141
- Title: Linked List Cycle
- Link: https://leetcode.com/problems/linked-list-cycle/
- Difficulty: Easy
- Language: Java
- Attempt type: guided practice

## SQL Problem

- Number: 1148
- Title: Article Views I
- Link: https://leetcode.com/problems/article-views-i/
- Difficulty: Easy
- Language: SQL
- Attempt type: guided practice

## Java Thinking

We need to check whether a linked list eventually points back to an earlier node.

Use two pointers:

- `slow` moves one node each time.
- `fast` moves two nodes each time.

If there is a cycle, `fast` will eventually catch `slow` inside the loop.
If there is no cycle, `fast` reaches `null` or `fast.next` reaches `null`.

## Java Pattern

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;

    if (slow == fast) {
        return true;
    }
}

return false;
```

For a list with a cycle:

```text
3 -> 2 -> 0 -> -4
     ^         |
     |_________|
```

`fast` keeps looping and eventually lands on the same node as `slow`.

## SQL Thinking

We need authors who viewed their own articles.

In each row, compare:

- `author_id`
- `viewer_id`

If they are equal, that author viewed their own article.
Use `DISTINCT` because the same author may appear in multiple rows.
Use `ORDER BY id` because the result must be sorted.

## SQL Pattern

```sql
SELECT DISTINCT author_id AS id
FROM Views
WHERE author_id = viewer_id
ORDER BY id;
```

## Complexity

- Java time: O(n)
- Java space: O(1)
- SQL concept: filtering rows, removing duplicates with `DISTINCT`, sorting

## Mistakes To Avoid

- Java: Compare nodes with `slow == fast`, not `slow.val == fast.val`.
- Java: The loop condition must check both `fast != null` and `fast.next != null`
  before moving `fast` two steps.
- SQL: Use `DISTINCT`; otherwise the same author can appear more than once.
- SQL: Rename `author_id` to `id` with `AS id`.
