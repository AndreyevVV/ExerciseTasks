package LeetCode.Daily_Challenge.Medium.Cheapest_Flights_Within_K_Stops;

import java.util.*;

public class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int inf = 1 << 30;

        int[] dist = new int[n];
        Arrays.fill(dist, inf);
        dist[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] tempDist = Arrays.copyOf(dist, n);

            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                if (dist[from] != inf && dist[from] + price < tempDist[to])
                    tempDist[to] = dist[from] + price;
            }
            dist = tempDist;
        }

        return dist[dst] == inf ? -1 : dist[dst];
    }
}
