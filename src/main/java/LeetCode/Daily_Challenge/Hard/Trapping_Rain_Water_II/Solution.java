package LeetCode.Daily_Challenge.Hard.Trapping_Rain_Water_II;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        if (m < 3 || n < 3)
            return 0;

        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }

        for (int j = 1; j < n - 1; j++) {
            pq.offer(new int[]{0, j, heightMap[0][j]});
            pq.offer(new int[]{m - 1, j, heightMap[m - 1][j]});
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        int water = 0;

        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int x = cell[0];
            int y = cell[1];
            int height = cell[2];

            for (int[] dir : DIRECTIONS) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    water += Math.max(0, height - heightMap[nx][ny]);
                    pq.offer(new int[]{nx, ny, Math.max(height, heightMap[nx][ny])});
                }
            }
        }

        return water;
    }
}
