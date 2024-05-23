package LeetCode.Daily_Challenge.Medium.The_Number_of_Beautiful_Subsets.Iterative_HashMap_solution;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int beautifulSubsets(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        int count = 1;
        int previous = 0;
        int prevPrev = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int current = entry.getKey();

            if (map.containsKey(current - k)) continue;

            previous = 0;

            while (map.containsKey(current)) {
                prevPrev = previous;
                previous = ((1 << map.get(current)) - 1) * count;
                count += prevPrev;
                current += k;
            }
            count += previous;
        }
        return count - 1;
    }
}
