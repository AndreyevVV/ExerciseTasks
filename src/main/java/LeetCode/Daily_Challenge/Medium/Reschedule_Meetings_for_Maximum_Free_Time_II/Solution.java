package LeetCode.Daily_Challenge.Medium.Reschedule_Meetings_for_Maximum_Free_Time_II;

public class Solution {

    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gaps = new int[n + 1];

        int prevEnd = 0;
        for (int i = 0; i < n; i++) {
            gaps[i] = startTime[i] - prevEnd;
            prevEnd = endTime[i];
        }
        gaps[n] = eventTime - prevEnd;

        int[] maxRightGap = new int[n + 1];
        for (int i = n - 1; i >= 0; i--)
            maxRightGap[i] = Math.max(maxRightGap[i + 1], gaps[i + 1]);

        int maxFree = 0;
        int maxLeftGap = 0;

        for (int i = 1; i <= n; i++) {
            int duration = endTime[i - 1] - startTime[i - 1];

            if (maxLeftGap >= duration || maxRightGap[i] >= duration)
                maxFree = Math.max(maxFree, gaps[i - 1] + duration + gaps[i]);

            maxFree = Math.max(maxFree, gaps[i - 1] + gaps[i]);

            maxLeftGap = Math.max(maxLeftGap, gaps[i - 1]);
        }

        return maxFree;
    }
}
