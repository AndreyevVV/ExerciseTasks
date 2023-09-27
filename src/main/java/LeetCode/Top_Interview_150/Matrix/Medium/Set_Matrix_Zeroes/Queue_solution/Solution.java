package LeetCode.Top_Interview_150.Matrix.Medium.Set_Matrix_Zeroes.Queue_solution;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;

        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> zeroQueue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zeroQueue.offer(new int[]{i, j});
                }
            }
        }

        while (!zeroQueue.isEmpty()) {
            int[] curr = zeroQueue.poll();
            int row = curr[0];
            int col = curr[1];

            for (int j = 0; j < n; j++) {
                matrix[row][j] = 0;
            }

            for (int i = 0; i < m; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}
