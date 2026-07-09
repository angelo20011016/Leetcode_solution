/**
 * LeetCode 58: Length of Last Word.
 *
 * Problem: https://leetcode.com/problems/length-of-last-word/
 */
public class P0058_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        // Time: O(n), Space: O(1)
        int index = s.length() - 1;

        // Ignore spaces at the end because they are not part of the last word.
        while (index >= 0) {
            boolean currentCharIsSpace = s.charAt(index) == ' ';
            if (!currentCharIsSpace) {
                break;
            }
            index--;
        }

        int length = 0;

        // Count characters until we hit a space or move past the start.
        while (index >= 0) {
            boolean currentCharIsSpace = s.charAt(index) == ' ';
            if (currentCharIsSpace) {
                break;
            }

            length++;
            index--;
        }

        return length;
    }

    public static void main(String[] args) {
        P0058_LengthOfLastWord solution = new P0058_LengthOfLastWord();

        System.out.println(solution.lengthOfLastWord("Hello World")); // Expected: 5
        System.out.println(solution.lengthOfLastWord("   fly me   to   the moon  ")); // Expected: 4
        System.out.println(solution.lengthOfLastWord("luffy is still joyboy")); // Expected: 6
    }
}
