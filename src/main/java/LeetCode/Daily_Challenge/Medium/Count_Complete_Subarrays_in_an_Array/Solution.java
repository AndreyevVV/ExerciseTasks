package LeetCode.Daily_Challenge.Medium.Count_Complete_Subarrays_in_an_Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;

        Set<Integer> uniqueSet = new HashSet<>();
        for (int num : nums)
            uniqueSet.add(num);
        int totalUnique = uniqueSet.size();

        int count = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);

            while (freqMap.size() == totalUnique) {
                count += (n - right);
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
                if (freqMap.get(nums[left]) == 0)
                    freqMap.remove(nums[left]);
                left++;
            }
        }

        return count;
    }
}
