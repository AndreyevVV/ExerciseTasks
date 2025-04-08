package LeetCode.Daily_Challenge.Easy.Minimum_Number_of_Operations_to_Make_Elements_in_Array_Distinct;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int minOps = (n + 2) / 3;

        for (int i = 0; i <= n; i += 3) {
            Set<Integer> set = new HashSet<>();
            boolean isDistinct = true;
            for (int j = i; j < n; j++) {
                if (!set.add(nums[j])) {
                    isDistinct = false;
                    break;
                }
            }
            if (isDistinct)
                minOps = Math.min(minOps, i / 3);
        }

        return minOps;
    }
}
