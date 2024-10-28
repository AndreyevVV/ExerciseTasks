package LeetCode.Daily_Challenge.Medium.Longest_Square_Streak_in_an_Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int longestSquareStreak(int[] nums) {
        Map<Integer, Integer> streakMap = new HashMap<>();
        Arrays.sort(nums);
        int maxLength = -1;

        for (int num : nums) {
            int sqrt = (int) Math.sqrt(num);

            if (sqrt * sqrt == num && streakMap.containsKey(sqrt)) {
                int streakLength = streakMap.get(sqrt) + 1;
                streakMap.put(num, streakLength);
                maxLength = Math.max(maxLength, streakLength);
            } else
                streakMap.put(num, 1);
        }

        return maxLength;
    }
}
