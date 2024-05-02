package LeetCode.Daily_Challenge.Easy.Largest_Positive_Integer_That_Exists_With_Its_Negative;

import java.util.HashSet;

public class Solution {

    public int findMaxK(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = -1;

        for (int num : nums) {
            if (set.contains(-num))
                max = Math.max(max, Math.abs(num));
            set.add(num);
        }
        return max;
    }
}
