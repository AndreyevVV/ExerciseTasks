package LeetCode.Daily_Challenge.Medium.Continuous_Subarrays;

import java.util.TreeMap;

public class Solution {

    public long continuousSubarrays(int[] nums) {
        TreeMap<Integer, Integer> frequencyMap = new TreeMap<>();
        int left = 0;
        long totalSubarrays = 0;

        for (int right = 0; right < nums.length; right++) {
            frequencyMap.put(nums[right], frequencyMap.getOrDefault(nums[right], 0) + 1);

            while (frequencyMap.lastKey() - frequencyMap.firstKey() > 2) {
                frequencyMap.put(nums[left], frequencyMap.get(nums[left]) - 1);

                if (frequencyMap.get(nums[left]) == 0)
                    frequencyMap.remove(nums[left]);

                left++;
            }

            totalSubarrays += (right - left + 1);
        }

        return totalSubarrays;
    }
}
