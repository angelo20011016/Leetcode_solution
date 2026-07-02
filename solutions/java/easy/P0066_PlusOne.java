import java.util.Arrays;

/**
 * LeetCode 66: Plus One.
 *
 * Problem: https://leetcode.com/problems/plus-one/
 *
 * Time complexity: O(n)
 * Space complexity: O(1), unless every digit is 9 and a new array is needed.
 *
 * Note: Reviewed with assistance on 2026-06-29.
 */
public class P0066_PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            // If this digit is not 9, adding one finishes the job.
            // No earlier digit needs to change because there is no carry.
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // 9 + 1 becomes 0 and sends one carry to the digit on the left.
            digits[i] = 0;
        }

        // Reaching here means the number was all 9s, like 999.
        // The answer needs one extra digit: 1000.
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        P0066_PlusOne solution = new P0066_PlusOne();

        System.out.println(Arrays.toString(solution.plusOne(new int[] {1, 2, 3}))); // Expected: [1, 2, 4]
        System.out.println(Arrays.toString(solution.plusOne(new int[] {4, 3, 2, 1}))); // Expected: [4, 3, 2, 2]
        System.out.println(Arrays.toString(solution.plusOne(new int[] {9}))); // Expected: [1, 0]
        System.out.println(Arrays.toString(solution.plusOne(new int[] {9, 9, 9}))); // Expected: [1, 0, 0, 0]
    }
}
