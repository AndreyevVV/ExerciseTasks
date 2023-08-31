package LeetCode.LeetCode_75.Intervals.Medium.Minimum_Number_of_Arrows_to_Burst_Balloons;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparing(e -> e[0]));
        int minArrows = 1, start = 0, end = 1;
        int previous = 0;
        for (int current = 1; current < points.length; current++) {
            if (points[current][start] > points[previous][end]) {
                minArrows++;
                previous = current;
            }
        }
        return minArrows;
    }
}
