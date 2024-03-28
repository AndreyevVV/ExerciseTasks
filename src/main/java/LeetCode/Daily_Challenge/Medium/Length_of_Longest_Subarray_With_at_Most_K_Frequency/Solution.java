package LeetCode.Daily_Challenge.Medium.Length_of_Longest_Subarray_With_at_Most_K_Frequency;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int maxSubarrayLength(int[] nums, int k) {
        if (k >= nums.length) return nums.length;

        Map<Integer, Integer> freqMap = new HashMap<>();

        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);

            while (freqMap.get(nums[right]) > k) {
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
