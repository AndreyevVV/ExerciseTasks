package LeetCode.Daily_Challenge.Medium.Binary_Subarrays_With_Sum.PrefixSum_solution;

public class Solution {

    public int numSubarraysWithSum(int[] nums, int goal) {
        int totalCount = 0;
        int sum = 0;
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 1;

        for (int num : nums) {
            sum += num;
            if (sum >= goal)
                totalCount += prefixSum[sum - goal];
            prefixSum[sum]++;
        }
        return totalCount;
    }
}
