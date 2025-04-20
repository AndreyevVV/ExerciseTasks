package LeetCode.Daily_Challenge.Medium.Rabbits_in_Forest;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int numRabbits(int[] answers) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : answers)
            count.put(a, count.getOrDefault(a, 0) + 1);

        int res = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int x = entry.getKey();
            int freq = entry.getValue();
            int groupSize = x + 1;
            int groups = (freq + x) / groupSize;
            res += groups * groupSize;
        }

        return res;
    }
}
