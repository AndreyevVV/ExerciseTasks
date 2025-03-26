package LeetCode.Daily_Challenge.Medium.Minimum_Operations_to_Make_a_UniValue_Grid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        List<Integer> values = new ArrayList<>();

        for (int[] row : grid)
            for (int num : row)
                values.add(num);

        int remainder = values.get(0) % x;
        for (int num : values)
            if (num % x != remainder) return -1;

        Collections.sort(values);
        int median = values.get(values.size() / 2);

        int operations = 0;
        for (int num : values)
            operations += Math.abs(num - median) / x;

        return operations;
    }
}
