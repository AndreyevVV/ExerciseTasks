package LeetCode.Daily_Challenge.Easy.Longest_Harmonious_Subsequence;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int findLHS(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums)
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

        int maxLength = 0;
        for (int key : freqMap.keySet()) {
            if (freqMap.containsKey(key + 1)) {
                int length = freqMap.get(key) + freqMap.get(key + 1);
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}
