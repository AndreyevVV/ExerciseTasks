package LeetCode.Daily_Challenge.Medium.Adjacent_Increasing_Subarrays_Detection_II;

import java.util.List;

public class Solution {
    
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int[] inc = new int[n];
        
        inc[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--)
            inc[i] = (nums.get(i) < nums.get(i + 1)) ? inc[i + 1] + 1 : 1;
        
        int maxK = 0;
        
        int[] end = new int[n];
        end[0] = 1;
        for (int i = 1; i < n; i++)
            end[i] = (nums.get(i) > nums.get(i - 1)) ? end[i - 1] + 1 : 1;

        for (int i = 0; i + 1 < n; i++) {
            int leftLen = end[i];
            int rightLen = inc[i + 1];
            maxK = Math.max(maxK, Math.min(leftLen, rightLen));
        }

        return maxK;
    }
}
