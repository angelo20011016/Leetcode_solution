/**
 * LeetCode 344: Reverse String.
 *
 * Problem: https://leetcode.com/problems/reverse-string/
 */
public class P0344_ReverseString {
    public void reverseString(char[] s) {
        // Time: O(n), Space: O(1)
        // left 從最左邊開始，right 從最右邊開始。
        int left = 0;
        int right = s.length - 1;

        // 只要 left 還在 right 左邊，就繼續交換。
        while (left < right) {
            // 先暫存左邊的字元，避免等一下被覆蓋掉。
            char temp = s[left];

            // 把右邊的字元放到左邊。
            s[left] = s[right];

            // 把原本左邊的字元放到右邊。
            s[right] = temp;

            // 兩個指針往中間靠近。
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        P0344_ReverseString solution = new P0344_ReverseString();

        char[] first = new char[] {'h', 'e', 'l', 'l', 'o'};
        solution.reverseString(first);
        printArray(first); // Expected: [o, l, l, e, h]

        char[] second = new char[] {'H', 'a', 'n', 'n', 'a', 'h'};
        solution.reverseString(second);
        printArray(second); // Expected: [h, a, n, n, a, H]
    }

    private static void printArray(char[] values) {
        System.out.print("[");
        for (int i = 0; i < values.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(values[i]);
        }
        System.out.println("]");
    }
}
