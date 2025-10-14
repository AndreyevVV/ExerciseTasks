package LeetCode.Daily_Challenge.Easy.Adjacent_Increasing_Subarrays_Detection_I;

import java.util.List;

public class Solution {
    
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int[] inc = new int[n];
        inc[0] = 1;

        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1))
                inc[i] = inc[i - 1] + 1;
            else
                inc[i] = 1;

            if (i >= 2 * k - 1)
                if (inc[i] >= k && inc[i - k] >= k) return true;
        }

        return false;
    }
}
