package LeetCode.Daily_Challenge.Hard.Minimum_Cost_to_Hire_K_Workers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double[][] workers = new double[n][2];

        for (int i = 0; i < n; i++) {
            workers[i][0] = (double) wage[i] / quality[i];
            workers[i][1] = (double) quality[i];
        }

        Arrays.sort(workers, Comparator.comparingDouble(a -> a[0]));

        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        double qualitySum = 0;
        double minCost = Double.MAX_VALUE;

        for (double[] worker : workers) {
            maxHeap.offer(worker[1]);

            qualitySum += worker[1];

            if (maxHeap.size() > k)
                qualitySum -= maxHeap.poll();

            if (maxHeap.size() == k)
                minCost = Math.min(minCost, qualitySum * worker[0]);
        }

        return minCost;
    }
}
