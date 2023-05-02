package LeetCode.LeetCode_75_Level_2.Day_1_Implementation_Simulation.Day_2_String.Medium.Spiral_Matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        dfs(matrix, 0, 0, list, visited);

        return list;
    }

    public void dfs(int[][] matrix, int sr, int sc, List<Integer> list, Set<Integer> visited) {

        if (sr < 0 || sc < 0 || sr >= matrix.length || sc >= matrix[0].length) return;

        int index = (sr * matrix[sr].length) + sc;
        if (visited.contains(index)) return;

        list.add(matrix[sr][sc]);
        visited.add(index);

        if (sr - 1 < 0 || visited.contains(((sr - 1) * matrix[sr - 1].length) + sc)) {
            dfs(matrix, sr, sc + 1, list, visited);
        }

        dfs(matrix, sr + 1, sc, list, visited);
        dfs(matrix, sr, sc - 1, list, visited);
        dfs(matrix, sr - 1, sc, list, visited);
    }
}
