package LeetCode.Daily_Challenge.Hard.Find_the_Minimum_Area_to_Cover_All_Ones_II;

public class Solution {

    public int minimumSum(int[][] grid) {
        int res = Integer.MAX_VALUE;

        for (int rot = 0; rot < 4; rot++) {
            int n = grid.length, m = grid[0].length;

            for (int i = 1; i < n; i++) {
                int top = minArea(grid, 0, i, 0, m);

                for (int j = 1; j < m; j++) {
                    int left = minArea(grid, i, n, 0, j);
                    int right = minArea(grid, i, n, j, m);
                    res = Math.min(res, top + left + right);
                }

                for (int i2 = i + 1; i2 < n; i2++) {
                    int mid = minArea(grid, i, i2, 0, m);
                    int bottom = minArea(grid, i2, n, 0, m);
                    res = Math.min(res, top + mid + bottom);
                }
            }
            grid = rotate(grid);
        }
        return res;
    }

    private int minArea(int[][] grid, int r1, int r2, int c1, int c2) {
        int minR = Integer.MAX_VALUE, minC = Integer.MAX_VALUE;
        int maxR = -1, maxC = -1;
        for (int i = r1; i < r2; i++) {
            for (int j = c1; j < c2; j++) {
                if (grid[i][j] == 1) {
                    minR = Math.min(minR, i);
                    maxR = Math.max(maxR, i);
                    minC = Math.min(minC, j);
                    maxC = Math.max(maxC, j);
                }
            }
        }
        if (maxR == -1) return 0;
        return (maxR - minR + 1) * (maxC - minC + 1);
    }

    private int[][] rotate(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] rotated = new int[m][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                rotated[j][n - 1 - i] = grid[i][j];

        return rotated;
    }
}
