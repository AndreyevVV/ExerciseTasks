package LeetCode.Daily_Challenge.Medium.Regions_Cut_By_Slashes;

public class Solution {

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[][] dp = new int[n * 3][n * 3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '/')
                    fill(dp, i * 3, j * 3 + 2, i * 3 + 1, j * 3 + 1, i * 3 + 2, j * 3);
                else if (grid[i].charAt(j) == '\\')
                    fill(dp, i * 3, j * 3, i * 3 + 1, j * 3 + 1, i * 3 + 2, j * 3 + 2);
            }
        }

        int regions = 0;
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                if (dp[i][j] == 0) {
                    regions++;
                    dfs(dp, i, j);
                }

        return regions;
    }

    private void fill(int[][] dp, int... positions) {
        for (int k = 0; k < positions.length; k += 2)
            dp[positions[k]][positions[k + 1]] = 1;
    }

    private void dfs(int[][] dp, int i, int j) {
        if (i < 0 || j < 0 || i >= dp.length || j >= dp[0].length || dp[i][j] != 0)
            return;

        dp[i][j] = 1;
        dfs(dp, i + 1, j);
        dfs(dp, i - 1, j);
        dfs(dp, i, j + 1);
        dfs(dp, i, j - 1);
    }
}
