package LeetCode.Problems.Medium.Maximum_Number_of_Fish_in_a_Grid;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().findMaxFish(new int[][]{
                {0, 2, 1, 0},
                {4, 0, 0, 3},
                {1, 0, 0, 4},
                {0, 3, 2, 0}}));
    }

    public int findMaxFish(int[][] grid) {

        int maxFishNumber = 0;

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] > 0)
                    maxFishNumber = Math.max(maxFishNumber, dfs(grid, i, j));
        return maxFishNumber;
    }

    public int dfs(int[][] grid, int sr, int sc) {
        if (sr < 0 || sc < 0 || sr >= grid.length || sc >= grid[0].length || grid[sr][sc] == 0) return 0;

        int fishNumber = grid[sr][sc];
        grid[sr][sc] = 0;

        fishNumber += dfs(grid, sr + 1, sc);
        fishNumber += dfs(grid, sr - 1, sc);
        fishNumber += dfs(grid, sr, sc + 1);
        fishNumber += dfs(grid, sr, sc - 1);

        return fishNumber;
    }
}
