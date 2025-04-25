package LeetCode.Daily_Challenge.Medium.Count_of_Interesting_Subarrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Integer, Long> countMap = new HashMap<>();
        countMap.put(0, 1L);
        long res = 0;
        int prefix = 0;

        for (int num : nums) {
            if (num % modulo == k)
                prefix++;

            int currentMod = prefix % modulo;
            int want = (currentMod - k + modulo) % modulo;
            res += countMap.getOrDefault(want, 0L);

            countMap.put(currentMod, countMap.getOrDefault(currentMod, 0L) + 1);
        }

        return res;
    }
}
