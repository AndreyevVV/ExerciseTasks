package LeetCode.Daily_Challenge.Medium.Check_if_Grid_can_be_Cut_into_Sections;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] rectangles = {{1, 0, 5, 2}, {0, 2, 2, 4}, {3, 2, 5, 3}, {0, 4, 4, 5}};
        System.out.println(sol.checkValidCuts(5, rectangles));
    }

    public boolean checkValidCuts(int n, int[][] rectangles) {
        return canPartition(rectangles, true) || canPartition(rectangles, false);
    }

    private boolean canPartition(int[][] rectangles, boolean isHorizontal) {
        int[][] intervals = new int[rectangles.length][2];

        for (int i = 0; i < rectangles.length; i++) {
            intervals[i][0] = isHorizontal ? rectangles[i][1] : rectangles[i][0];
            intervals[i][1] = isHorizontal ? rectangles[i][3] : rectangles[i][2];
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int sections = 0, maxEnd = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] >= maxEnd) sections++;
            maxEnd = Math.max(maxEnd, interval[1]);
        }

        return sections >= 2;
    }
}
