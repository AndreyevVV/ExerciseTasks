package LeetCode.Daily_Challenge.Hard.Number_of_Submatrices_That_Sum_to_Target;

public class Solution {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] prefixSum = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = matrix[i - 1][j - 1] +
                        prefixSum[i - 1][j] +
                        prefixSum[i][j - 1] -
                        prefixSum[i - 1][j - 1];
            }
        }

        int count = 0;

        for (int top = 1; top <= m; top++)
            for (int bottom = top; bottom <= m; bottom++)
                for (int left = 1; left <= n; left++)
                    for (int right = left; right <= n; right++) {
                        int currentSum = prefixSum[bottom][right] -
                                prefixSum[top - 1][right] -
                                prefixSum[bottom][left - 1] +
                                prefixSum[top - 1][left - 1];
                        if (currentSum == target)
                            count++;
                    }

        return count;
    }
}
