package LeetCode.Daily_Challenge.Medium.Continuous_Subarray_Sum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {23, 2, 4, 6, 7};
        int k1 = 6;
        System.out.println(solution.checkSubarraySum(nums1, k1)); // true

        int[] nums2 = {23, 2, 6, 4, 7};
        int k2 = 6;
        System.out.println(solution.checkSubarraySum(nums2, k2)); // true

        int[] nums3 = {23, 2, 6, 4, 7};
        int k3 = 13;
        System.out.println(solution.checkSubarraySum(nums3, k3)); // false

        int[] nums4 = {5, 0, 0, 0};
        int k4 = 3;
        System.out.println(solution.checkSubarraySum(nums4, k4)); // true
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> remainderMap = new HashMap<>();
        int dum = 0;

        remainderMap.put(0, -1);

        for (int i = 0; i < n; i++) {
            dum += nums[i];

            int remainder = k == 0 ? dum : dum % k;

            if (remainderMap.containsKey(remainder)) {
                if (i - remainderMap.get(remainder) > 1)
                    return true;
            } else
                remainderMap.put(remainder, i);
        }
        return false;
    }
}
