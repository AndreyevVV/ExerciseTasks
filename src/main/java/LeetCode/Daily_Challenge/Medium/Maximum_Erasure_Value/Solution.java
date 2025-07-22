package LeetCode.Daily_Challenge.Medium.Maximum_Erasure_Value;

import java.util.HashSet;

public class Solution {

    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int left = 0, currSum = 0, maxSum = 0;

        for (int right = 0; right < nums.length; right++) {
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                currSum -= nums[left];
                left++;
            }
            set.add(nums[right]);
            currSum += nums[right];
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }    
}
