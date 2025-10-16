package LeetCode.Daily_Challenge.Medium.Smallest_Missing_Non_negative_Integer_After_Operations;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        for (int num : nums) {
            int mod = ((num % value) + value) % value; // always non-negative
            freq.put(mod, freq.getOrDefault(mod, 0) + 1);
        }
        
        int x = 0;
        while (true) {
            int mod = x % value;
            if (!freq.containsKey(mod) || freq.get(mod) == 0)
                return x;
            freq.put(mod, freq.get(mod) - 1);
            x++;
        }
    }
}
