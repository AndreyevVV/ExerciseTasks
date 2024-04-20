package LeetCode.Daily_Challenge.Medium.Find_All_Groups_of_Farmland;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public int[][] findFarmland(int[][] land) {
        List<int[]> result = new ArrayList<>();

        int m = land.length;
        int n = land[0].length;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (land[i][j] == 1) {
                    int[] farmland = dfs(land, i, j);
                    result.add(farmland);
                }

        return result.toArray(int[][]::new);
    }

    private int[] dfs(int[][] land, int row, int col) {
        int m = land.length;
        int n = land[0].length;

        int[] farmland = new int[4];
        farmland[0] = row;
        farmland[1] = col;

        int r = row;
        int c = col;
        while (r < m && land[r][col] == 1) r++;
        while (c < n && land[row][c] == 1) c++;
        farmland[2] = r - 1;
        farmland[3] = c - 1;

        for (int i = row; i < r; i++)
            for (int j = col; j < c; j++)
                land[i][j] = 0;

        return farmland;
    }
}
