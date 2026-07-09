import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 119: Pascal's Triangle II.
 *
 * Problem: https://leetcode.com/problems/pascals-triangle-ii/
 */
public class P0119_PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        for (int currentRowIndex = 0; currentRowIndex <= rowIndex; currentRowIndex++) {
            // 每一列最後一個數字一定是 1，先放進去再更新中間的位置。
            row.add(1);

            // 從右往左更新，才不會太早覆蓋左邊還需要使用的上一列數字。
            for (int columnIndex = currentRowIndex - 1; columnIndex > 0; columnIndex--) {
                int leftParent = row.get(columnIndex - 1);
                int rightParent = row.get(columnIndex);
                int newValue = leftParent + rightParent;

                row.set(columnIndex, newValue);
            }
        }

        return row;
    }

    public static void main(String[] args) {
        P0119_PascalsTriangleII solution = new P0119_PascalsTriangleII();

        System.out.println(solution.getRow(0));
        // Expected: [1]

        System.out.println(solution.getRow(3));
        // Expected: [1, 3, 3, 1]

        System.out.println(solution.getRow(4));
        // Expected: [1, 4, 6, 4, 1]
    }
}
