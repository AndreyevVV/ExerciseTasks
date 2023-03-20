package LeetCode.Algorithms.Medium.Maximum_Matrix_Sum;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().maxMatrixSum(new int[][]{{1,-1},{-1,1}}));
    }

    public long maxMatrixSum(int[][] matrix) {

        int n = matrix.length;
        int minValue = Integer.MAX_VALUE;
        int negFlag = 1;

        long sum = 0;
        for (int[] num : matrix) {
            for (int i = 0; i < n; i++) {
                sum += Math.abs(num[i]);
                if (num[i] < 0) negFlag *= -1;
                minValue = Math.min(minValue, Math.abs(num[i]));
            }
        }
        return sum - minValue + (long) negFlag * minValue;
    }
}
