package LeetCode.Daily_Challenge.Medium.Maximum_Average_Pass_Ratio;

import java.util.PriorityQueue;

public class Solution {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int[] c : classes) {
            int pass = c[0];
            int total = c[1];
            double currentRatio = (double) pass / total;
            double nextRatio = (double) (pass + 1) / (total + 1);
            double gain = nextRatio - currentRatio;
            maxHeap.offer(new double[]{gain, pass, total});
        }

        for (int i = 0; i < extraStudents; i++) {
            double[] top = maxHeap.poll();
            double gain = top[0];
            int pass = (int) top[1];
            int total = (int) top[2];

            pass++;
            total++;

            double currentRatio = (double) pass / total;
            double nextRatio = (double) (pass + 1) / (total + 1);
            double newGain = nextRatio - currentRatio;

            maxHeap.offer(new double[]{newGain, pass, total});
        }

        double totalRatio = 0.0;
        int n = classes.length;
        while (!maxHeap.isEmpty()) {
            double[] top = maxHeap.poll();
            int pass = (int) top[1];
            int total = (int) top[2];
            totalRatio += (double) pass / total;
        }

        return totalRatio / n;
    }
}
