/**
 * LeetCode 977: Squares of a Sorted Array.
 *
 * Problem: https://leetcode.com/problems/squares-of-a-sorted-array/
 *
 * Time complexity: O(n)
 * Space complexity: O(n)
 *
 * Attempt type: reviewed with assistance
 */
public class P0977_SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];

        int left = 0;
        int right = nums.length - 1;
        int writeIndex = nums.length - 1;

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            // The largest square must come from one of the two ends because
            // the input is already sorted from negative to positive.
            if (leftSquare > rightSquare) {
                result[writeIndex] = leftSquare;
                left++;
            } else {
                result[writeIndex] = rightSquare;
                right--;
            }

            writeIndex--;
        }

        return result;
    }

    public static void main(String[] args) {
        P0977_SquaresOfASortedArray solution = new P0977_SquaresOfASortedArray();

        printArray(solution.sortedSquares(new int[] {-4, -1, 0, 3, 10}));
        printArray(solution.sortedSquares(new int[] {-7, -3, 2, 3, 11}));
        printArray(solution.sortedSquares(new int[] {-5, -3, -2, -1}));
    }

    private static void printArray(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(nums[i]);
        }
        System.out.println("]");
    }
}
