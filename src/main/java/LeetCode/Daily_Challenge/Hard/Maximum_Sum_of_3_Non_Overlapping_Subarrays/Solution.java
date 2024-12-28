package LeetCode.Daily_Challenge.Hard.Maximum_Sum_of_3_Non_Overlapping_Subarrays;

public class Solution {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];

        for (int i = 0; i < n; i++)
            sum[i + 1] = sum[i] + nums[i];

        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[3];

        int maxSum = sum[k] - sum[0];
        left[k - 1] = 0;
        for (int i = k; i < n; i++) {
            int curSum = sum[i + 1] - sum[i + 1 - k];
            if (curSum > maxSum) {
                left[i] = i + 1 - k;
                maxSum = curSum;
            } else
                left[i] = left[i - 1];
        }

        maxSum = sum[n] - sum[n - k];
        right[n - k] = n - k;
        for (int i = n - k - 1; i >= 0; i--) {
            int curSum = sum[i + k] - sum[i];
            if (curSum >= maxSum) {
                right[i] = i;
                maxSum = curSum;
            } else
                right[i] = right[i + 1];
        }

        maxSum = 0;
        for (int i = k; i <= n - 2 * k; i++) {
            int l = left[i - 1];
            int r = right[i + k];
            int total = (sum[i + k] - sum[i]) + (sum[l + k] - sum[l]) + (sum[r + k] - sum[r]);

            if (total > maxSum) {
                maxSum = total;
                result[0] = l;
                result[1] = i;
                result[2] = r;
            }
        }

        return result;
    }
}
