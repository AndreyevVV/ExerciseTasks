package LeetCode.Daily_Challenge.Hard.Cherry_Pickup_II;

public class Solution {
    public static void main(String[] args) {
        Solution cherryPickup = new Solution();

        int[][] grid1 = {{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}};
        System.out.println(cherryPickup.cherryPickup(grid1));

        int[][] grid2 = {{1, 0, 0, 0, 0, 0, 1}, {2, 0, 0, 0, 0, 3, 0}, {2, 0, 9, 0, 0, 0, 0},
                {0, 3, 0, 5, 4, 0, 0}, {1, 0, 2, 3, 0, 0, 6}};
        System.out.println(cherryPickup.cherryPickup(grid2));
    }

    public int cherryPickup(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][][] dp = new int[rows][cols][cols];

        for (int j1 = 0; j1 < cols; j1++)
            for (int j2 = 0; j2 < cols; j2++)
                dp[rows - 1][j1][j2] = grid[rows - 1][j1] + (j1 == j2 ? 0 : grid[rows - 1][j2]);

        for (int i = rows - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < cols; j1++) {
                for (int j2 = 0; j2 < cols; j2++) {
                    int maxVal = Integer.MIN_VALUE;
                    for (int k1 = Math.max(0, j1 - 1); k1 <= Math.min(j1 + 1, cols - 1); k1++) {
                        for (int k2 = Math.max(0, j2 - 1); k2 <= Math.min(j2 + 1, cols - 1); k2++) {
                            int val = dp[i + 1][k1][k2] + (j1 == j2 ? grid[i][j1] : grid[i][j1] + grid[i][j2]);
                            maxVal = Math.max(maxVal, val);
                        }
                    }
                    dp[i][j1][j2] = maxVal;
                }
            }
        }

        return dp[0][0][cols - 1];
    }
}
