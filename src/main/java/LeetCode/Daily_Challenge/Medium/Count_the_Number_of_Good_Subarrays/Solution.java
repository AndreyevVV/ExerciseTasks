package LeetCode.Daily_Challenge.Medium.Count_the_Number_of_Good_Subarrays;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        long res = 0;
        long pairCount = 0;

        for (int right = 0; right < nums.length; right++) {
            int val = nums[right];
            int count = freq.getOrDefault(val, 0);
            pairCount += count;
            freq.put(val, count + 1);

            while (pairCount >= k) {
                res += nums.length - right;
                int leftVal = nums[left];
                int leftCount = freq.get(leftVal);
                pairCount -= (leftCount - 1);
                if (leftCount == 1)
                    freq.remove(leftVal);
                else
                    freq.put(leftVal, leftCount - 1);
                left++;
            }
        }

        return res;
    }
}
