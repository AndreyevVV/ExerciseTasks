package LeetCode.Daily_Challenge.Medium.Largest_Divisible_Subset.Backtracking_solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().largestDivisibleSubset(new int[]{1, 2, 4, 8}));
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 0, nums);

        List<Integer> longestSubset = new ArrayList<>();
        for (List<Integer> subset : result)
            if (subset.size() > longestSubset.size())
                longestSubset = subset;

        return longestSubset;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> subset, int index, int[] nums) {
        if (!result.contains(subset))
            result.add(new ArrayList<>(subset));

        for (int i = index; i < nums.length; i++) {
            if (isValid(subset, nums[i])) {
                subset.add(nums[i]);
                backtrack(result, subset, i + 1, nums);
                subset.remove(subset.size() - 1);
            }
        }
    }

    private boolean isValid(List<Integer> subset, int num) {
        for (int n : subset)
            if (num % n != 0 && n % num != 0)
                return false;
        return true;
    }
}
