package LeetCode.Daily_Challenge.Hard.Find_the_Maximum_Sum_of_Node_Values.Optimized_Solution;

public class Solution {

    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long baseSum = 0;
        long gainSum = 0;
        long minAbsGain = Long.MAX_VALUE;
        int positiveGainCount = 0;

        for (int num : nums) {
            baseSum += num;
            long gain = (num ^ k) - num;

            if (gain > 0) {
                gainSum += gain;
                positiveGainCount++;
            }

            minAbsGain = Math.min(minAbsGain, Math.abs(gain));
        }

        if (positiveGainCount % 2 != 0)
            gainSum -= minAbsGain;

        return baseSum + gainSum;
    }
}
