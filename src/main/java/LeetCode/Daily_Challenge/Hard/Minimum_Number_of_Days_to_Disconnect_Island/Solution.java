package LeetCode.Daily_Challenge.Hard.Minimum_Number_of_Days_to_Disconnect_Island;

public class Solution {

    private void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || visited[i][j])
            return;

        visited[i][j] = true;

        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i, j + 1);
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i, j - 1);
    }

    private boolean isDisconnected(int[][] grid) {
        int count = 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                    dfs(grid, visited, i, j);
                }
        return count != 1;
    }

    public int minDays(int[][] grid) {
        if (isDisconnected(grid))
            return 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (isDisconnected(grid))
                        return 1;
                    grid[i][j] = 1;
                }
        }
        return 2;
    }
}
