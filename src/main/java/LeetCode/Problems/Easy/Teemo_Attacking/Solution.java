package LeetCode.Problems.Easy.Teemo_Attacking;

public class Solution {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0 || duration == 0)
            return 0;

        int totalDuration = 0;
        int previousAttackTime = timeSeries[0];

        for (int i = 1; i < timeSeries.length; i++) {
            int currentAttackTime = timeSeries[i];
            totalDuration += Math.min(duration, currentAttackTime - previousAttackTime);
            previousAttackTime = currentAttackTime;
        }

        totalDuration += duration;

        return totalDuration;
    }
}
