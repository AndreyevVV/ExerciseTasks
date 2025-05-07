package LeetCode.Daily_Challenge.Medium.Find_Minimum_Time_to_Reach_Last_Room_I;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length;
        int n = moveTime[0].length;

        int[][] dist = new int[m][n];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;

        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c.time));
        pq.offer(new Cell(0, 0, 0));

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!pq.isEmpty()) {
            Cell current = pq.poll();
            int x = current.row;
            int y = current.col;
            int t = current.time;

            if (x == m - 1 && y == n - 1)
                return t;

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int wait = Math.max(0, moveTime[nx][ny] - t);
                    int arrivalTime = t + 1 + wait;

                    if (arrivalTime < dist[nx][ny]) {
                        dist[nx][ny] = arrivalTime;
                        pq.offer(new Cell(nx, ny, arrivalTime));
                    }
                }
            }
        }

        return -1;
    }

    static class Cell {
        int row, col, time;

        public Cell(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
}
