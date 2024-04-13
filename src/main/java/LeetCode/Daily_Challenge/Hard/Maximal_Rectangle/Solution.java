package LeetCode.Daily_Challenge.Hard.Maximal_Rectangle;

import java.util.Stack;

public class Solution {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];
        int maxArea = 0;

        for (int j = 0; j < cols; j++)
            dp[0][j] = matrix[0][j] == '1' ? 1 : 0;

        for (int i = 1; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (matrix[i][j] == '1')
                    dp[i][j] = dp[i - 1][j] + 1;

        for (int i = 0; i < rows; i++)
            maxArea = Math.max(maxArea, largestRectangleArea(dp[i]));

        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int maxArea = 0;
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || heights[i] < heights[stack.peek()])) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
