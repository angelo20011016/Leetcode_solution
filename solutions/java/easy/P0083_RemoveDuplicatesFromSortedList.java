/**
 * LeetCode 83: Remove Duplicates from Sorted List.
 *
 * Problem: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class P0083_RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        // Time: O(n), Space: O(1)
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        P0083_RemoveDuplicatesFromSortedList solution = new P0083_RemoveDuplicatesFromSortedList();

        ListNode first = buildList(new int[] {1, 1, 2});
        printList(solution.deleteDuplicates(first));
        // Expected: 1 -> 2

        ListNode second = buildList(new int[] {1, 1, 2, 3, 3});
        printList(solution.deleteDuplicates(second));
        // Expected: 1 -> 2 -> 3

        ListNode third = buildList(new int[] {});
        printList(solution.deleteDuplicates(third));
        // Expected: empty line
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

    private static void printList(ListNode head) {
        ListNode current = head;

        while (current != null) {
            if (current != head) {
                System.out.print(" -> ");
            }

            System.out.print(current.val);
            current = current.next;
        }

        System.out.println();
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
