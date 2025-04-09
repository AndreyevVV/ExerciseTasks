package LeetCode.Daily_Challenge.Easy.Minimum_Operations_to_Make_Array_Values_Equal_to_K;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

    public int minOperations(int[] nums, int k) {
        for (int num : nums)
            if (num < k) return -1;

        Set<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int num : nums)
            if (num > k)
                set.add(num);

        return set.size();
    }
}
