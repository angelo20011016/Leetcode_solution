/**
 * LeetCode 141: Linked List Cycle.
 *
 * Problem: https://leetcode.com/problems/linked-list-cycle/
 */
public class P0141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        // Time: O(n), Space: O(1)
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
    }

    public static void main(String[] args) {
        P0141_LinkedListCycle solution = new P0141_LinkedListCycle();

        ListNode first = buildList(new int[] {3, 2, 0, -4});
        connectTailTo(first, 1);
        System.out.println(solution.hasCycle(first));
        // Expected: true

        ListNode second = buildList(new int[] {1, 2});
        connectTailTo(second, 0);
        System.out.println(solution.hasCycle(second));
        // Expected: true

        ListNode third = buildList(new int[] {1});
        System.out.println(solution.hasCycle(third));
        // Expected: false
    }

    private static ListNode buildList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    private static void connectTailTo(ListNode head, int index) {
        if (head == null || index < 0) {
            return;
        }

        ListNode target = null;
        ListNode current = head;
        ListNode tail = null;
        int currentIndex = 0;

        while (current != null) {
            if (currentIndex == index) {
                target = current;
            }

            tail = current;
            current = current.next;
            currentIndex++;
        }

        if (tail != null) {
            tail.next = target;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
