package LeetCode.Daily_Challenge.Medium.Maximum_Average_Pass_Ratio;

import java.util.PriorityQueue;

public class Solution {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        
        for (int[] c : classes) {
            int p = c[0], t = c[1];
            double delta = gain(p, t);
            pq.offer(new double[]{delta, p, t});
        }

        for (int i = 0; i < extraStudents; i++) {
            double[] top = pq.poll();
            int p = (int) top[1];
            int t = (int) top[2];
            
            p++;
            t++;
            
            double delta = gain(p, t);
            pq.offer(new double[]{delta, p, t});
        }

        double sum = 0.0;
        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            int p = (int) cur[1];
            int t = (int) cur[2];
            sum += (double) p / t;
        }
        
        return sum / classes.length;
    }

    private double gain(int p, int t) {
        return ((double)(p + 1) / (t + 1)) - ((double) p / t);
    }
}
