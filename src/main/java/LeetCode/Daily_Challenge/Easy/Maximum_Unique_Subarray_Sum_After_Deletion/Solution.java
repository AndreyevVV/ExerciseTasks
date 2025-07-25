package LeetCode.Daily_Challenge.Easy.Maximum_Unique_Subarray_Sum_After_Deletion;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE, sum = 0;

        for (int num : nums) {
            set.add(num);
            max = Math.max(max, num);
        }

        for (int num : set)
            if (num > 0) sum += num;

        return sum > 0 ? sum : max;
    }
}
