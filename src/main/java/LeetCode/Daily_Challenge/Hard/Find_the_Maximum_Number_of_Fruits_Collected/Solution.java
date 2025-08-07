package LeetCode.Daily_Challenge.Hard.Find_the_Maximum_Number_of_Fruits_Collected;

import java.util.Arrays;

public class Solution {
    
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int total = 0;

        for (int i = 0; i < n; i++)
            total += fruits[i][i];

        for (int pass = 0; pass < 2; pass++) {
            if (pass == 1)
                transpose(fruits);

            int[] prev = new int[n];
            Arrays.fill(prev, -1);
            prev[n - 1] = fruits[0][n - 1];

            for (int row = 1; row < n - 1; row++) {
                int[] curr = new int[n];
                Arrays.fill(curr, -1);

                for (int col = 0; col < n; col++) {
                    if (prev[col] < 0) continue;

                    for (int d = -1; d <= 1; d++) {
                        int nextCol = col + d;
                        if (nextCol >= 0 && nextCol < n)
                            curr[nextCol] = Math.max(curr[nextCol], prev[col] + fruits[row][nextCol]);
                    }
                }

                prev = curr;
            }

            total += prev[n - 1];
        }

        return total;
    }

    private void transpose(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = grid[i][j];
                grid[i][j] = grid[j][i];
                grid[j][i] = temp;
            }
        }
    }
}
