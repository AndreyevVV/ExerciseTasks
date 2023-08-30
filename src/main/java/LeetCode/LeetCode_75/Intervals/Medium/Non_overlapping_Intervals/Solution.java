package LeetCode.LeetCode_75.Intervals.Medium.Non_overlapping_Intervals;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparing(e -> e[0]));
        int answer = 0;
        int j = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[j][1]) {
                answer++;
                if (intervals[i][1] <= intervals[j][1]) j = i;
            } else j = i;
        }
        return answer;
    }
}
