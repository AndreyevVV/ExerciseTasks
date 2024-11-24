package LeetCode.Daily_Challenge.Medium.Maximum_Matrix_Sum;

public class Solution {

    public long maxMatrixSum(int[][] matrix) {
        long totalSum = 0;
        int minAbsValue = Integer.MAX_VALUE;
        int negativeCount = 0;

        for (int[] ints : matrix) {
            for (int value : ints) {
                totalSum += Math.abs(value);
                if (value < 0)
                    negativeCount++;
                minAbsValue = Math.min(minAbsValue, Math.abs(value));
            }
        }

        if (negativeCount % 2 != 0)
            totalSum -= 2L * minAbsValue;

        return totalSum;
    }
}
