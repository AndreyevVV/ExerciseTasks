package LeetCode.Daily_Challenge.Medium.Sort_Matrix_by_Diagonals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                map.computeIfAbsent(key, k -> new ArrayList<>()).add(grid[i][j]);
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> diag = entry.getValue();
            if (entry.getKey() >= 0)
                diag.sort(Collections.reverseOrder());
            else
                Collections.sort(diag);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                grid[i][j] = map.get(key).remove(0);
            }
        }

        return grid;
    }
}
