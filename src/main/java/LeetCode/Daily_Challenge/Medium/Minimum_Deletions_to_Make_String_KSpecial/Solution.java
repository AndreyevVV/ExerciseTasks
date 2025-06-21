package LeetCode.Daily_Challenge.Medium.Minimum_Deletions_to_Make_String_KSpecial;

import java.util.*;

public class Solution {

    public int minimumDeletions(String word, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char c : word.toCharArray())
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);

        List<Integer> freqs = new ArrayList<>(freqMap.values());
        Collections.sort(freqs);

        int minDeletions = Integer.MAX_VALUE;

        for (int t : freqs) {
            int deletions = 0;
            for (int f : freqs)
                if (f < t)
                    deletions += f;
                else if (f > t + k)
                    deletions += f - (t + k);
            minDeletions = Math.min(minDeletions, deletions);
        }

        return minDeletions;
    }
}
