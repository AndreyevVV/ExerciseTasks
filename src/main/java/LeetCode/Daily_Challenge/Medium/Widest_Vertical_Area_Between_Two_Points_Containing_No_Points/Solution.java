package LeetCode.Daily_Challenge.Medium.Widest_Vertical_Area_Between_Two_Points_Containing_No_Points;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] - b[0]);

        int maxWidth = 0;
        for (int i = 1; i < points.length; i++)
            maxWidth = Math.max(maxWidth, points[i][0] - points[i - 1][0]);

        return maxWidth;
    }
}
