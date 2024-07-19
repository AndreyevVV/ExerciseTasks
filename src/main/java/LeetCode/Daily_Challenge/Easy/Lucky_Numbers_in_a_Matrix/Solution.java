package LeetCode.Daily_Challenge.Easy.Lucky_Numbers_in_a_Matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<>();

        int[] minRow = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[i].length; j++)
                if (matrix[i][j] < min)
                    min = matrix[i][j];
            minRow[i] = min;
        }

        int[] maxCol = new int[matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < matrix.length; i++)
                if (matrix[i][j] > max)
                    max = matrix[i][j];
            maxCol[j] = max;
        }

        Set<Integer> maxColsSet = new HashSet<>();
        for (int max : maxCol)
            maxColsSet.add(max);

        for (int min : minRow)
            if (maxColsSet.contains(min))
                luckyNumbers.add(min);

        return luckyNumbers;
    }
}
