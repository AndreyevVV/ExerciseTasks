package LeetCode.LeetCode_75_Level_2.Day_10_Graph_BFS_DFS.Medium.Pacific_Atlantic_Water_Flow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().pacificAtlantic(
                new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}}));
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> result = new ArrayList<>();

        int sr = heights.length;
        if (sr == 0) return result;

        int sc = heights[0].length;

        boolean[][] pacificCanBeAchieved = new boolean[sr][sc];
        boolean[][] atlanticCanBeAchieved = new boolean[sr][sc];

        for (int i = 0; i < sc; i++) {
            dfs(heights, 0, i, heights[0][i], pacificCanBeAchieved);
            dfs(heights, sr - 1, i, heights[sr - 1][i], atlanticCanBeAchieved);
        }

        for (int i = 0; i < sr; i++) {
            dfs(heights, i, 0, heights[i][0], pacificCanBeAchieved);
            dfs(heights, i, sc - 1, heights[i][sc - 1], atlanticCanBeAchieved);
        }

        for (int i = 0; i < sr; i++) {
            for (int j = 0; j < sc; j++) {
                if (pacificCanBeAchieved[i][j] && atlanticCanBeAchieved[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    public void dfs(int[][] heights, int sr, int sc, int borderHeight, boolean[][] oceanCanBeAchieved) {
        if (sr < 0 || sc < 0 || sr >= heights.length || sc >= heights[0].length || borderHeight > heights[sr][sc]
                   || oceanCanBeAchieved[sr][sc]) return;

        oceanCanBeAchieved[sr][sc] = true;

        dfs(heights, sr + 1, sc, heights[sr][sc], oceanCanBeAchieved);
        dfs(heights, sr - 1, sc, heights[sr][sc], oceanCanBeAchieved);
        dfs(heights, sr, sc + 1, heights[sr][sc], oceanCanBeAchieved);
        dfs(heights, sr, sc - 1, heights[sr][sc], oceanCanBeAchieved);
    }
}
