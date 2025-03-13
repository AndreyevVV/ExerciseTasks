package LeetCode.Daily_Challenge.Medium.Zero_Array_Transformation_II;

public class Solution {

    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, m = queries.length;

        if (isZero(nums)) return 0;

        int left = 1, right = m, result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canMakeZero(nums, queries, mid)) {
                result = mid;
                right = mid - 1;
            } else
                left = mid + 1;
        }

        return result;
    }

    private boolean isZero(int[] nums) {
        for (int num : nums)
            if (num != 0) return false;

        return true;
    }

    private boolean canMakeZero(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        int[] diff = new int[n + 1];

        for (int i = 0; i < k; i++) {
            int l = queries[i][0], r = queries[i][1], val = queries[i][2];
            diff[l] -= val;
            if (r + 1 < n) diff[r + 1] += val;
        }

        int current = 0;
        for (int i = 0; i < n; i++) {
            current += diff[i];
            if (nums[i] + current > 0) return false;
        }

        return true;
    }
}
