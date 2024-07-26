package LeetCode.Daily_Challenge.Medium.Find_the_City_With_the_Smallest_Number_of_Neighbors_at_a_Threshold_Distance;

import java.util.Arrays;

public class Solution {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];

        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++)

            dist[i][i] = 0;
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            dist[from][to] = weight;
            dist[to][from] = weight;
        }

        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);


        int minReachableCities = Integer.MAX_VALUE;
        int cityWithMinReachableCities = -1;
        for (int i = 0; i < n; i++) {
            int reachableCities = 0;
            for (int j = 0; j < n; j++)
                if (i != j && dist[i][j] <= distanceThreshold)
                    reachableCities++;

            if (reachableCities < minReachableCities ||
                    (reachableCities == minReachableCities && i > cityWithMinReachableCities)) {
                minReachableCities = reachableCities;
                cityWithMinReachableCities = i;
            }
        }

        return cityWithMinReachableCities;
    }
}
