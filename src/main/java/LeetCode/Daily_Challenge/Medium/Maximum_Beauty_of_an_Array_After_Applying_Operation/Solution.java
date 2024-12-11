package LeetCode.Daily_Challenge.Medium.Maximum_Beauty_of_an_Array_After_Applying_Operation;

import java.util.Arrays;

public class Solution {

    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);

        int maxBeauty = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > 2 * k)
                left++;
            maxBeauty = Math.max(maxBeauty, right - left + 1);
        }

        return maxBeauty;
    }
}
