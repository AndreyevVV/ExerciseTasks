package LeetCode.Daily_Challenge.Medium.Split_a_String_Into_the_Max_Number_of_Unique_Substrings;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int maxUniqueSplit(String s) {
        return backtrack(s, 0, new HashSet<>());
    }

    private int backtrack(String s, int start, Set<String> seen) {
        if (start == s.length())
            return 0;

        int maxSplits = 0;

        for (int i = start + 1; i <= s.length(); i++) {
            String substring = s.substring(start, i);

            if (!seen.contains(substring)) {
                seen.add(substring);

                int splits = 1 + backtrack(s, i, seen);

                maxSplits = Math.max(maxSplits, splits);

                seen.remove(substring);
            }
        }

        return maxSplits;
    }
}
