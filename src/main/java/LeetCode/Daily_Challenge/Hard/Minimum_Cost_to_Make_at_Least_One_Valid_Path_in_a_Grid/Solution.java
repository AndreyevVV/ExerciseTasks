package LeetCode.Daily_Challenge.Hard.Minimum_Cost_to_Make_at_Least_One_Valid_Path_in_a_Grid;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] cost = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                cost[i][j] = Integer.MAX_VALUE;

        cost[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int x = current[0], y = current[1], currentCost = current[2];

            if (currentCost > cost[x][y])
                continue;

            for (int d = 0; d < 4; d++) {
                int nx = x + DIRECTIONS[d][0];
                int ny = y + DIRECTIONS[d][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int newCost = currentCost + (grid[x][y] == d + 1 ? 0 : 1);
                    if (newCost < cost[nx][ny]) {
                        cost[nx][ny] = newCost;
                        pq.offer(new int[]{nx, ny, newCost});
                    }
                }
            }
        }

        return cost[m - 1][n - 1];
    }
}
