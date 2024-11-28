package LeetCode.Daily_Challenge.Hard.Minimum_Obstacle_Removal_to_Reach_Corner;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {

    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Deque<int[]> deque = new ArrayDeque<>();
        int[][] dist = new int[m][n];

        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        dist[0][0] = 0;
        deque.offer(new int[]{0, 0});

        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int x = current[0], y = current[1];

            for (int[] dir : directions) {
                int nx = x + dir[0], ny = y + dir[1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int newDist = dist[x][y] + grid[nx][ny];
                    if (newDist < dist[nx][ny]) {
                        dist[nx][ny] = newDist;

                        if (grid[nx][ny] == 0)
                            deque.offerFirst(new int[]{nx, ny});
                        else
                            deque.offerLast(new int[]{nx, ny});
                    }
                }
            }
        }

        return dist[m - 1][n - 1];
    }
}
