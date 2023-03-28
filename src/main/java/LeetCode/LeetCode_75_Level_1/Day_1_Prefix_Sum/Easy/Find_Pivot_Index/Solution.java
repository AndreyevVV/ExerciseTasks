package LeetCode.LeetCode_75_Level_1.Day_1_Prefix_Sum.Easy.Find_Pivot_Index;

public class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        int prefSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sum - prefSum - nums[i] == prefSum) return i;
            prefSum += nums[i];
        }
        return -1;
    }
}
