package LeetCode.LeetCode_75_Level_2.Day_13_Dynamic_Programming.Medium.Maximum_Product_Subarray;

public class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int m = 1, n = 1;

        for (int i = 0, j = nums.length - 1; i < nums.length && j >= 0; i++, j--) {
            m *= nums[i];
            n *= nums[j];
            ans = Math.max(ans, Math.max(m, n));
            if (m == 0) m = 1;
            if (n == 0) n = 1;
        }
        return ans;
    }
}
