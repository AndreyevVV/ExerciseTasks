package LeetCode.Daily_Challenge.Hard.Length_of_Longest_V_Shaped_Diagonal_Segment;

public class Solution {
    
    private final int[][] dirs = {
        {1, 1},
        {1, -1},
        {-1, -1},
        {-1, 1}
    };

    public int lenOfVDiagonal(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int maxLen = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1)
                    for (int d = 0; d < 4; d++)
                        maxLen = Math.max(maxLen, dfs(grid, i, j, d, 0, 1));

        return maxLen;
    }

    private int dfs(int[][] grid, int x, int y, int dir, int turnUsed, int length) {
        int n = grid.length, m = grid[0].length;
        int best = length;

        int nextVal = (length % 2 == 1) ? 2 : 0;

        int nx = x + dirs[dir][0];
        int ny = y + dirs[dir][1];

        if (inBounds(nx, ny, n, m) && grid[nx][ny] == nextVal)
            best = Math.max(best, dfs(grid, nx, ny, dir, turnUsed, length + 1));

        if (turnUsed == 0) {
            int newDir = (dir + 1) % 4;
            int tx = x + dirs[newDir][0];
            int ty = y + dirs[newDir][1];

            if (inBounds(tx, ty, n, m) && grid[tx][ty] == nextVal)
                best = Math.max(best, dfs(grid, tx, ty, newDir, 1, length + 1));
        }

        return best;
    }

    private boolean inBounds(int x, int y, int n, int m) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}
