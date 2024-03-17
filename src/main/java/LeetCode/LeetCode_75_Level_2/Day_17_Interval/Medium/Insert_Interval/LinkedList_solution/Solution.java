package LeetCode.LeetCode_75_Level_2.Day_17_Interval.Medium.Insert_Interval.LinkedList_solution;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().insert(new int[][]
                {{0, 10}, {14, 14}, {15, 20}}, new int[]{11, 11})));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0], end = newInterval[1], i = 0, length = intervals.length;
        LinkedList<int[]> result = new LinkedList<>();

        while (i < length && start > intervals[i][0]) result.add(intervals[i++]);

        if (result.isEmpty() || result.getLast()[1] < start) result.add(newInterval);
        else result.getLast()[1] = Math.max(result.getLast()[1], end);

        int[] tempInt = new int[2];

        while (i < length) {
            tempInt = intervals[i++];
            int s = tempInt[0], e = tempInt[1];
            if (result.getLast()[1] < s) result.add(tempInt);
            else result.getLast()[1] = Math.max(result.getLast()[1], e);
        }
        return result.toArray(int[][]::new);
    }
}
