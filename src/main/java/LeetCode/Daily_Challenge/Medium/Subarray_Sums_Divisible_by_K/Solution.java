package LeetCode.Daily_Challenge.Medium.Subarray_Sums_Divisible_by_K;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;
            int remainder = sum % k;

            if (remainder < 0)
                remainder += k;

            if (countMap.containsKey(remainder))
                count += countMap.get(remainder);

            countMap.put(remainder, countMap.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }
}
