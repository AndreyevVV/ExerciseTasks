package LeetCode.LeetCode_75_Level_2.Day_17_Interval.Medium.Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().merge(new int[][]{{15, 18}, {1, 3}, {8, 10}, {2, 6}})));
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(e -> e[0]));

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        for (int[] interval : intervals) {
            int[] lastIntervalInMerged = merged.get(merged.size() - 1);
            if (lastIntervalInMerged[1] < interval[0]) {
                merged.add(interval);
            } else {
                lastIntervalInMerged[1] = Math.max(lastIntervalInMerged[1], interval[1]);
            }
        }

        return merged.toArray(int[][]::new);
    }
}
