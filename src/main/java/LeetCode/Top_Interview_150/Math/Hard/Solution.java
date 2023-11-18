package LeetCode.Top_Interview_150.Math.Hard;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static int maxPoints(int[][] points) {
        if (points == null || points.length == 0)
            return 0;

        int maxPoints = 1;

        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopeCount = new HashMap<>();
            int vertLines = 0;
            int duplPoits = 0;
            int localMax = 1;

            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];

                if (x1 == x2 && y1 == y2)
                    duplPoits++;
                else if (x1 == x2) {
                    vertLines++;
                    localMax = Math.max(localMax, vertLines + 1);
                } else {
                    int dx = x2 - x1;
                    int dy = y2 - y1;
                    int gcd = gcd(dx, dy);

                    String slope = (dy / gcd) + "/" + (dx / gcd);

                    slopeCount.put(slope, slopeCount.getOrDefault(slope, 1) + 1);
                    localMax = Math.max(localMax, slopeCount.get(slope));
                }
            }
            maxPoints = Math.max(maxPoints, localMax + duplPoits);
        }
        return maxPoints;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
