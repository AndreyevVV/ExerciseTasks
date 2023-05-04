package LeetCode.LeetCode_75_Level_2.Day_1_Implementation_Simulation.Medium.Spiral_Matrix.Recursive;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        int color = 101;
        List<Integer> list = new ArrayList<>();

        dfs(matrix, 0, 0, list, color);
        return list;
    }

    public void dfs(int[][] matrix, int sr, int sc, List<Integer> list, int color) {
        if (sr < 0 || sc < 0 || sr >= matrix.length || sc >= matrix[0].length || matrix[sr][sc] == color) return;

        list.add(matrix[sr][sc]);
        matrix[sr][sc] = color;

        if (sr - 1 < 0 || matrix[sr - 1][sc] == color) {
            dfs(matrix, sr, sc + 1, list, color);
        }

        dfs(matrix, sr + 1, sc, list, color);
        dfs(matrix, sr, sc - 1, list, color);
        dfs(matrix, sr - 1, sc, list, color);
    }
}
