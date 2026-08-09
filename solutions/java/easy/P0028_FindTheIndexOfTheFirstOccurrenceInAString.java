/**
 * LeetCode 28: Find the Index of the First Occurrence in a String.
 *
 * Problem: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 */
public class P0028_FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        // 空字串可以視為從任何字串的開頭就找到。
        if (needle.isEmpty()) {
            return 0;
        }

        // 再往後開始時，haystack 剩下的字元就不夠放完整的 needle，無須檢查。
        int lastStartIndex = haystack.length() - needle.length();

        // 逐一嘗試：把 needle 的第一個字元對齊 haystack 的每一個合法位置。
        for (int startIndex = 0; startIndex <= lastStartIndex; startIndex++) {
            // 每換一個起點，都要從 needle 的第一個字元重新開始比對。
            int needleIndex = 0;

            // startIndex + needleIndex 是 haystack 中目前要比較的位置。
            // 只要字元相同，就繼續檢查 needle 的下一個字元。
            while (needleIndex < needle.length()
                    && haystack.charAt(startIndex + needleIndex) == needle.charAt(needleIndex)) {
                needleIndex++;
            }

            // needle 的所有字元都比完，表示從 startIndex 開始找到完整的 needle。
            boolean foundCompleteNeedle = needleIndex == needle.length();
            if (foundCompleteNeedle) {
                return startIndex;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        P0028_FindTheIndexOfTheFirstOccurrenceInAString solution =
                new P0028_FindTheIndexOfTheFirstOccurrenceInAString();

        System.out.println(solution.strStr("sadbutsad", "sad")); // Expected: 0
        System.out.println(solution.strStr("leetcode", "leeto")); // Expected: -1
        System.out.println(solution.strStr("mississippi", "issip")); // Expected: 4
        System.out.println(solution.strStr("abc", "")); // Expected: 0
    }
}
