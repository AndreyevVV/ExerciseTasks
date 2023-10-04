package LeetCode.Top_Interview_150.Hashmap.Medium.Longest_Consecutive_Sequence;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Map<Integer, Integer> sequenceLengths = new HashMap<>();
        int maxLength = 0;

        for (int num : nums) {
            if (!sequenceLengths.containsKey(num)) {
                int left = sequenceLengths.getOrDefault(num - 1, 0);
                int right = sequenceLengths.getOrDefault(num + 1, 0);

                int currentLength = left + right + 1;

                sequenceLengths.put(num, currentLength);
                sequenceLengths.put(num - left, currentLength);
                sequenceLengths.put(num + right, currentLength);

                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }
}
