package LeetCode.Daily_Challenge.Medium.Make_Sum_Divisible_by_P;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int minSubarray(int[] nums, int p) {
        int totalSum = 0;
        for (int num : nums)
            totalSum = (totalSum + num) % p;

        if (totalSum == 0)
            return 0;

        Map<Integer, Integer> prefixModMap = new HashMap<>();
        prefixModMap.put(0, -1);

        int currentPrefixSum = 0;
        int minLength = nums.length;

        for (int i = 0; i < nums.length; i++) {
            currentPrefixSum = (currentPrefixSum + nums[i]) % p;
            int requiredMod = (currentPrefixSum - totalSum + p) % p;

            if (prefixModMap.containsKey(requiredMod)) {
                minLength = Math.min(minLength, i - prefixModMap.get(requiredMod));
            }

            prefixModMap.put(currentPrefixSum, i);
        }
        return minLength == nums.length ? -1 : minLength;
    }
}
