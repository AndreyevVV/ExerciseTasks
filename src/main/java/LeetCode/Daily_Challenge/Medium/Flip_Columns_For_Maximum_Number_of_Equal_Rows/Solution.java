package LeetCode.Daily_Challenge.Medium.Flip_Columns_For_Maximum_Number_of_Equal_Rows;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> patternCount = new HashMap<>();

        for (int[] row : matrix) {
            StringBuilder pattern = new StringBuilder();
            int base = row[0];

            for (int val : row)
                pattern.append(val ^ base);

            patternCount.put(pattern.toString(), patternCount.getOrDefault(pattern.toString(), 0) + 1);
        }

        int maxRows = 0;
        for (int count : patternCount.values())
            maxRows = Math.max(maxRows, count);

        return maxRows;
    }
}
