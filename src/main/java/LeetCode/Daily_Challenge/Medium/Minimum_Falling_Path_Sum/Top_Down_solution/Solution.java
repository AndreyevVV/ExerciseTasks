package LeetCode.Daily_Challenge.Medium.Minimum_Falling_Path_Sum.Top_Down_solution;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}));
    }

    public int minFallingPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int minimumSum = Integer.MAX_VALUE;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int j = 0; j < cols; j++)
            minimumSum = Math.min(minimumSum, dfs(matrix, 0, j, new Integer[rows][cols]));

        return minimumSum;
    }

    private int dfs(int[][] matrix, int row, int col, Integer[][] memo) {
        if (row >= matrix.length)
            return 0;
        if (col < 0 || col >= matrix[0].length) return Integer.MAX_VALUE;

        if (memo[row][col] != null)
            return memo[row][col];

        int minPathSum = matrix[row][col] + Math.min(
                                            Math.min(dfs(matrix, row + 1, col - 1, memo),
                                                     dfs(matrix, row + 1, col + 1, memo)),
                                                     dfs(matrix, row + 1, col, memo));

        memo[row][col] = minPathSum;
        return minPathSum;
    }
}
