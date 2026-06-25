/**
 * LeetCode 234: Palindrome Linked List.
 *
 * Problem: https://leetcode.com/problems/palindrome-linked-list/
 */
public class P0234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        // Time: O(n), Space: O(1)
        // 如果 linked list 是空的，或只有一個節點，一定是回文。
        if (head == null || head.next == null) {
            return true;
        }

        // slow 一次走一步，fast 一次走兩步。
        // fast 走到尾端時，slow 會剛好停在中間附近。
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 從 slow 開始反轉後半段 linked list。
        // 例如 1 -> 2 -> 2 -> 1，後半段 2 -> 1 會變成 1 -> 2。
        ListNode secondHalf = reverseList(slow);

        // firstHalf 從原本的 head 開始，secondHalf 從反轉後的後半段開始。
        ListNode firstHalf = head;

        // 只需要比較 secondHalf 的長度。
        // 如果每一格的值都一樣，代表 linked list 是回文。
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }

            // 兩邊都往下一個節點移動。
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    private ListNode reverseList(ListNode head) {
        // previous 代表反轉後，current 前面的那個節點。
        ListNode previous = null;

        // current 代表現在正在處理的節點。
        ListNode current = head;

        while (current != null) {
            // 先把原本的下一個節點存起來。
            // 因為下一行會改掉 current.next。
            ListNode nextNode = current.next;

            // 把 current 的箭頭反過來，指向 previous。
            current.next = previous;

            // previous 和 current 都往前推進一格。
            previous = current;
            current = nextNode;
        }

        // current 變成 null 時，previous 就是反轉後的新 head。
        return previous;
    }

    public static void main(String[] args) {
        P0234_PalindromeLinkedList solution = new P0234_PalindromeLinkedList();

        System.out.println(solution.isPalindrome(buildList(new int[] {1, 2, 2, 1})));
        // Expected: true

        System.out.println(solution.isPalindrome(buildList(new int[] {1, 2})));
        // Expected: false

        System.out.println(solution.isPalindrome(buildList(new int[] {1, 2, 3, 2, 1})));
        // Expected: true
    }

    private static ListNode buildList(int[] values) {
        // dummy 是假的起點，方便建立 linked list。
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int value : values) {
            // 建立新節點，接到 current 後面。
            current.next = new ListNode(value);

            // current 移到剛建立的新節點。
            current = current.next;
        }

        // dummy.next 才是真正的 linked list 起點。
        return dummy.next;
    }

    static class ListNode {
        // 節點存的數字。
        int val;

        // 指向下一個節點。
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
