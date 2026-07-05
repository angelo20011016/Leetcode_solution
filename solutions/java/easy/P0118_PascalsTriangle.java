import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 118: Pascal's Triangle.
 *
 * Problem: https://leetcode.com/problems/pascals-triangle/
 */
public class P0118_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
            List<Integer> currentRow = new ArrayList<>();

            for (int columnIndex = 0; columnIndex <= rowIndex; columnIndex++) {
                boolean isFirstNumberInRow = columnIndex == 0;
                boolean isLastNumberInRow = columnIndex == rowIndex;
                boolean shouldBeOne = isFirstNumberInRow || isLastNumberInRow;

                // 每一列的第一個數字和最後一個數字一定都是 1。
                // 例如第 4 列是 [1, 3, 3, 1]，左右邊界都是 1。
                if (shouldBeOne) {
                    currentRow.add(1);
                } else {
                    int middleNumber = getMiddleNumber(triangle, rowIndex, columnIndex);
                    currentRow.add(middleNumber);
                }
            }

            triangle.add(currentRow);
        }

        return triangle;
    }

    private int getMiddleNumber(
            List<List<Integer>> triangle,
            int rowIndex,
            int columnIndex
    ) {
        List<Integer> previousRow = triangle.get(rowIndex - 1);

        // 中間的數字來自「上一列的左上方」加上「上一列的右上方」。
        // 例如要算 [1, 3, 3, 1] 下一列中間的 6：
        // leftParent = 3, rightParent = 3, 所以 6 = 3 + 3。
        int leftParent = previousRow.get(columnIndex - 1);
        int rightParent = previousRow.get(columnIndex);

        return leftParent + rightParent;
    }

    public static void main(String[] args) {
        P0118_PascalsTriangle solution = new P0118_PascalsTriangle();

        System.out.println(solution.generate(5));
        // Expected: [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]

        System.out.println(solution.generate(1));
        // Expected: [[1]]
    }
}
