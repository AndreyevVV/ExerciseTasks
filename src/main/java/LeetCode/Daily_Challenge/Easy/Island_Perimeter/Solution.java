package LeetCode.Daily_Challenge.Easy.Island_Perimeter;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().islandPerimeter(
                new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}));
    }

    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 1)
                    return dfs(grid, i, j);
        return 0;
    }

    private int dfs(int[][] grid, int sr, int sc) {
        if (sr < 0 || sc < 0 || sr >= grid.length || sc >= grid[0].length || grid[sr][sc] == 0)
            return 1;

        if (grid[sr][sc] == 2)
            return 0;

        grid[sr][sc] = 2;

        int perimeter = 0;

        perimeter += dfs(grid, sr + 1, sc);
        perimeter += dfs(grid, sr - 1, sc);
        perimeter += dfs(grid, sr, sc + 1);
        perimeter += dfs(grid, sr, sc - 1);

        return perimeter;
    }
}
