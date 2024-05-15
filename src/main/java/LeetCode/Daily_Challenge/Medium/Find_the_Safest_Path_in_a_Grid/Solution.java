package LeetCode.Daily_Challenge.Medium.Find_the_Safest_Path_in_a_Grid;

import java.util.*;

public class Solution {

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] distance = new int[n][n];

        for (int[] row : distance)
            Arrays.fill(row, Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid.get(r).get(c) == 1) {
                    queue.add(new int[]{r, c});
                    distance[r][c] = 0;
                }
            }
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currRow = current[0], currCol = current[1];
            int currDist = distance[currRow][currCol];

            for (int[] dir : directions) {
                int newRow = currRow + dir[0], newCol = currCol + dir[1];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && distance[newRow][newCol] > currDist + 1) {
                    distance[newRow][newCol] = currDist + 1;
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        pq.add(new int[]{0, 0, distance[0][0]});
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currRow = current[0], currCol = current[1], currSafeFactor = current[2];

            if (currRow == n - 1 && currCol == n - 1)
                return currSafeFactor;

            for (int[] dir : directions) {
                int newRow = currRow + dir[0], newCol = currCol + dir[1];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    pq.add(new int[]{newRow, newCol, Math.min(currSafeFactor, distance[newRow][newCol])});
                }
            }
        }

        return 0;
    }
}
