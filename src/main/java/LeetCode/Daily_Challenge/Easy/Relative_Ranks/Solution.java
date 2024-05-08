package LeetCode.Daily_Challenge.Easy.Relative_Ranks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];

        Map<Integer, Integer> scoreMap = new HashMap<>();
        for (int i = 0; i < n; i++)
            scoreMap.put(score[i], i);

        Arrays.sort(score);
        for (int i = n - 1; i >= 0; i--) {
            int index = scoreMap.get(score[i]);
            if (i == n - 1)
                result[index] = "Gold Medal";
            else if (i == n - 2)
                result[index] = "Silver Medal";
            else if (i == n - 3)
                result[index] = "Bronze Medal";
            else
                result[index] = Integer.toString(n - i);
        }

        return result;
    }
}
