/**
 * LeetCode 125: Valid Palindrome.
 *
 * Problem: https://leetcode.com/problems/valid-palindrome/
 *
 * Time complexity: O(n)
 * Space complexity: O(1)
 *
 * Note: Reviewed with assistance on 2026-06-25.
 */
public class P0125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Ignore punctuation, spaces, and other symbols because the problem
            // only compares letters and digits.
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));

            if (leftChar != rightChar) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        P0125_ValidPalindrome solution = new P0125_ValidPalindrome();

        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama")); // Expected: true
        System.out.println(solution.isPalindrome("race a car"));                    // Expected: false
        System.out.println(solution.isPalindrome(" "));                             // Expected: true
        System.out.println(solution.isPalindrome("0P"));                            // Expected: false
    }
}
