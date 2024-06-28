package LeetCode.Daily_Challenge.Medium.Maximum_Total_Importance_of_Roads;

import java.util.Arrays;

public class Solution {

    public long maximumImportance(int n, int[][] roads) {
        int[] degrees = new int[n];
        for (int[] road : roads) {
            degrees[road[0]]++;
            degrees[road[1]]++;
        }

        Integer[] cities = new Integer[n];
        for (int i = 0; i < n; i++)
            cities[i] = i;

        Arrays.sort(cities, (a, b) -> degrees[b] - degrees[a]);

        int[] values = new int[n];
        for (int i = 0; i < n; i++)
            values[cities[i]] = n - i;

        long totalImportance = 0;
        for (int[] road : roads)
            totalImportance += values[road[0]] + values[road[1]];

        return totalImportance;
    }
}
