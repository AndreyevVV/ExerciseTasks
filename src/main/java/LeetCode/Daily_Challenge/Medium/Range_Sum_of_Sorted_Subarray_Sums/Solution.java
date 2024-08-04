package LeetCode.Daily_Challenge.Medium.Range_Sum_of_Sorted_Subarray_Sums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    private static final int MOD = 1_000_000_007;

    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> subarraySums = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                subarraySums.add(sum);
            }
        }

        Collections.sort(subarraySums);

        long result = 0;
        for (int i = left - 1; i < right; i++)
            result = (result + subarraySums.get(i)) % MOD;

        return (int) result;
    }
}
