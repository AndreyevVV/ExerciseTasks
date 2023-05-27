package LeetCode.LeetCode_75_Level_2.Day_10_Graph_BFS_DFS.Medium.Rotting_Oranges;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
    }

    public int orangesRotting(int[][] grid) {
        int countFresh = 0;

        if (grid == null || grid.length == 0) return 0;

        int sr = grid.length;
        int sc = grid[0].length;

        for (int i = 0; i < sr; i++) {
            for (int j = 0; j < sc; j++) {
                if (grid[i][j] == 2) {
                    dfs(grid, i, j, -1, new int[1]);
                }
                if (grid[i][j] != 0) {
                    countFresh++;
                }
            }
        }
        if (countFresh == 0) {
            return 0;
        }

        int cnt = 0;

        for (int[] ints : grid) {
            for (int j = 0; j < sc; j++) {
                if (ints[j] == 1) return -1;
                else if (ints[j] < 0) cnt = Math.min(ints[j], cnt);
            }
        }

        return cnt == 0 ? 0 : -cnt - 1;
    }

    private static void dfs(int[][] grid, int sr, int sc, int nextMin, int[] cash) {

        if (cash[0] > nextMin) cash[0] = nextMin;
        grid[sr][sc] = nextMin--;

        if (sr < grid.length - 1 && (grid[sr + 1][sc] == 1 || grid[sr + 1][sc] < nextMin))
            dfs(grid, sr + 1, sc, nextMin, cash);

        if (sr > 0 && (grid[sr - 1][sc] == 1 || grid[sr - 1][sc] < nextMin))
            dfs(grid, sr - 1, sc, nextMin, cash);

        if (sc < grid[sr].length - 1 && (grid[sr][sc + 1] == 1 || grid[sr][sc + 1] < nextMin))
            dfs(grid, sr, sc + 1, nextMin, cash);

        if (sc > 0 && (grid[sr][sc - 1] == 1 || grid[sr][sc - 1] < nextMin))
            dfs(grid, sr, sc - 1, nextMin, cash);
    }
}
