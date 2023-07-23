package LeetCode.LeetCode_75.Hash_Map_Set.Medium.Equal_Row_and_Column_Pairs;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().equalPairs(new int[][]
                {{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}}));
    }

    public int equalPairs(int[][] grid) {
        if (grid == null || grid.length == 0) throw new RuntimeException("Incorrect input");
        AtomicInteger answer = new AtomicInteger();

        Map<String, Integer> rowsFrequencyMap = new HashMap<>();

        for (int[] row : grid) {
            StringBuilder rowString = new StringBuilder();
            for (int j = 0; j < grid[0].length; j++) {
                rowString.append(row[j]).append(" ");
            }
            rowsFrequencyMap.put(rowString.toString(), rowsFrequencyMap
                    .getOrDefault(rowString.toString(), 0) + 1);
        }
        System.out.println(rowsFrequencyMap);

        Map<String, Integer> colsFrequencyMap = new HashMap<>();

        for (int j = 0; j < grid[0].length; j++) {
            StringBuilder colString = new StringBuilder();
            for (int[] ints : grid) {
                colString.append(ints[j]).append(" ");
            }
            colsFrequencyMap.put(colString.toString(), colsFrequencyMap
                    .getOrDefault(colString.toString(), 0) + 1);
        }
        System.out.println(colsFrequencyMap);

        rowsFrequencyMap.forEach((key, value) -> {
            if (colsFrequencyMap.containsKey(key)) answer.set(answer.get() + (value * colsFrequencyMap.get(key)));
        });

        return answer.get();
    }
}
