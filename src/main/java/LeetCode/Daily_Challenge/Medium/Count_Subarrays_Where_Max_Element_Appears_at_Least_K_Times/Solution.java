package LeetCode.Daily_Challenge.Medium.Count_Subarrays_Where_Max_Element_Appears_at_Least_K_Times;

public class Solution {

    public long countSubarrays(int[] nums, int k) {
        long count = 0;
        int maxValue = 0, freq = 0, length = nums.length;

        for (int num : nums)
            maxValue = Math.max(maxValue, num);

        int left = 0;

        for (int right = 0; right < length; right++) {
            if (nums[right] == maxValue)
                freq++;

            while (freq >= k) {
                count += length - right;
                if (nums[left] == maxValue)
                    freq--;
                left++;
            }
        }
        return count;
    }
}
