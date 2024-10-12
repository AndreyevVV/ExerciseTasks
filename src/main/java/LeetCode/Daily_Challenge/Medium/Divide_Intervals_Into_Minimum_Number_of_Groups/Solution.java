package LeetCode.Daily_Challenge.Medium.Divide_Intervals_Into_Minimum_Number_of_Groups;

import java.util.Arrays;

public class Solution {

    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];

        for (int i = 0; i < n; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int end = 0, groupCount = 0;

        for (int start : startTimes) {
            if (start > endTimes[end])
                end++;
            else
                groupCount++;
        }

        return groupCount;
    }
}
