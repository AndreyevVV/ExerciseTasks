package LeetCode.Daily_Challenge.Medium.Path_with_Maximum_Gold;

public class Solution {

    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] != 0)
                    maxGold = Math.max(maxGold, dfs(grid, i, j));

        return maxGold;
    }

    private int dfs(int[][] grid, int sr, int sc) {
        if (sr < 0 || sc < 0 || sr >= grid.length || sc >= grid[0].length || grid[sr][sc] == 0)
            return 0;

        int gold = grid[sr][sc];
        grid[sr][sc] = 0;

        int maxGoldFromCurrent = 0;
        maxGoldFromCurrent = Math.max(maxGoldFromCurrent, dfs(grid, sr + 1, sc));
        maxGoldFromCurrent = Math.max(maxGoldFromCurrent, dfs(grid, sr - 1, sc));
        maxGoldFromCurrent = Math.max(maxGoldFromCurrent, dfs(grid, sr, sc + 1));
        maxGoldFromCurrent = Math.max(maxGoldFromCurrent, dfs(grid, sr, sc - 1));

        grid[sr][sc] = gold;

        return gold + maxGoldFromCurrent;
    }
}
