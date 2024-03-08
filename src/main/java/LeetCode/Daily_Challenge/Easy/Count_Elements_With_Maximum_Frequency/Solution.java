package LeetCode.Daily_Challenge.Easy.Count_Elements_With_Maximum_Frequency;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxFrequencyElements(new int[]{1, 2, 2, 3, 1, 4}));
    }

    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] maxFreq = {0};

        for (int num : nums) {
            int freq = map.getOrDefault(num, 0) + 1;
            maxFreq[0] = Math.max(freq, maxFreq[0]);
            map.put(num, freq);
        }
        return (int)map.entrySet().stream().filter(e -> e.getValue() == maxFreq[0]).count() * maxFreq[0];
    }
}
