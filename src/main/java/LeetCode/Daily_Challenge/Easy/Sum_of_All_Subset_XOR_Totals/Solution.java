package LeetCode.Daily_Challenge.Easy.Sum_of_All_Subset_XOR_Totals;

public class Solution {

    public int subsetXORSum(int[] nums) {
        return backtrack(nums, 0, 0);
    }

    private int backtrack(int[] nums, int index, int xorSum) {
        if (index == nums.length)
            return xorSum;

        int include = backtrack(nums, index + 1, xorSum ^ nums[index]);
        int exclude = backtrack(nums, index + 1, xorSum);

        return include + exclude;
    }
}
