package LeetCode.Daily_Challenge.Hard.Find_the_Number_of_Ways_to_Place_People_II;

import java.util.Arrays;

public class Solution {
    
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a, b) -> 
            a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(b[0], a[0])
        );

        int n = points.length;
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            int yi = points[i][1];
            int minY = Integer.MAX_VALUE;

            for (int j = i + 1; j < n; j++) {
                int yj = points[j][1];

                if (yj >= yi && yj < minY) {
                    count++;
                    minY = yj;
                    if (yi == yj) break;
                }
            }
        }

        return count;
    }
}
