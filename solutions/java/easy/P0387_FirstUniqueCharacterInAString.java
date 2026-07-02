import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 387: First Unique Character in a String.
 *
 * Problem: https://leetcode.com/problems/first-unique-character-in-a-string/
 * Difficulty: Easy
 *
 * Time: O(n)
 * Space: O(k), where k is the number of different characters.
 *
 * Note: Completed with assistance on 2026-06-21.
 */
public class P0387_FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        // key 是字元，value 是該字元出現的次數。
        // 例如輸入 "aab"，統計結果會是 {a=2, b=1}。
        Map<Character, Integer> characterCounts = new HashMap<>();

        // 第一次走訪：逐一統計每個字元出現幾次。
        for (int i = 0; i < s.length(); i++) {
            char currentCharacter = s.charAt(i);

            // getOrDefault 的意思是：
            // 若字元已存在，就取得目前次數；若不存在，就從 0 開始。
            int currentCount = characterCounts.getOrDefault(currentCharacter, 0);
            characterCounts.put(currentCharacter, currentCount + 1);
        }

        // 第二次走訪：從字串最左邊開始找。
        // 第一個出現次數為 1 的字元，就是題目要求的答案。
        for (int i = 0; i < s.length(); i++) {
            char currentCharacter = s.charAt(i);
            int count = characterCounts.get(currentCharacter);

            if (count == 1) {
                return i;
            }
        }

        // 所有字元都重複出現時，回傳 -1。
        return -1;
    }

    public static void main(String[] args) {
        P0387_FirstUniqueCharacterInAString solution =
                new P0387_FirstUniqueCharacterInAString();

        System.out.println(solution.firstUniqChar("leetcode"));      // Expected: 0
        System.out.println(solution.firstUniqChar("loveleetcode"));  // Expected: 2
        System.out.println(solution.firstUniqChar("aabb"));          // Expected: -1
    }
}
