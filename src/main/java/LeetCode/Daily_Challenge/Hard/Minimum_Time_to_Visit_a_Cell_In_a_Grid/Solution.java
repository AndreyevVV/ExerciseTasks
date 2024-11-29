package LeetCode.Daily_Challenge.Hard.Minimum_Time_to_Visit_a_Cell_In_a_Grid;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int minimumTime(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        if (grid[0][1] > 1 && grid[1][0] > 1)
            return -1;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[][] visited = new boolean[rows][cols];

        pq.offer(new int[]{0, 0, 0});
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int time = current[0], row = current[1], col = current[2];

            for (int[] dir : DIRECTIONS) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (isOutOfBounds(newRow, newCol, rows, cols) || visited[newRow][newCol])
                    continue;

                int newTime = time + 1;

                if (grid[newRow][newCol] > newTime)
                    newTime += ((grid[newRow][newCol] - newTime + 1) / 2) * 2;

                if (newRow == rows - 1 && newCol == cols - 1)
                    return newTime;

                visited[newRow][newCol] = true;
                pq.offer(new int[]{newTime, newRow, newCol});
            }
        }

        return -1;
    }

    private boolean isOutOfBounds(int row, int col, int rows, int cols) {
        return row < 0 || row >= rows || col < 0 || col >= cols;
    }
}
