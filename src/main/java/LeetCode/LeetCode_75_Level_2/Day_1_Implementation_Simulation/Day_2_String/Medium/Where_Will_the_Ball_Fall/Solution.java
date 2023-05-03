package LeetCode.LeetCode_75_Level_2.Day_1_Implementation_Simulation.Day_2_String.Medium.Where_Will_the_Ball_Fall;

public class Solution {

    public int[] findBall(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[] ans = new int[n];
        for (int i = 0; i < ans.length; i++) ans[i] = -1;

        int k = 0;

        for (int j = 0; j < n; j++) {
            dfs(grid, 0, j, m, n, ans, k);
            k++;
        }
        return ans;
    }

    void dfs(int[][] grid, int i, int j, int m, int n, int[] ans, int bottomCell) {

        if (i == m) {
            ans[bottomCell] = j;
            return;
        }

        if (grid[i][j] == 1 && (j + 1 >= n || grid[i][j + 1] == -1)) ;

        else if (grid[i][j] == -1 && (j - 1 < 0 || grid[i][j - 1] == 1)) ;

        else if (grid[i][j] == 1) dfs(grid, i + 1, j + 1, m, n, ans, bottomCell);

        else if (grid[i][j] == -1) dfs(grid, i + 1, j - 1, m, n, ans, bottomCell);
    }
}
