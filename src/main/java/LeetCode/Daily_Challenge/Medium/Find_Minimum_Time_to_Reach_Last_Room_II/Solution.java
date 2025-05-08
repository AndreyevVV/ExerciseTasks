package LeetCode.Daily_Challenge.Medium.Find_Minimum_Time_to_Reach_Last_Room_II;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public int minTimeToReach(int[][] moveTime) {
        int rows = moveTime.length, cols = moveTime[0].length;
        boolean[][] visited = new boolean[rows][cols];

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.offer(new int[]{0, 0, 0, 0});
        visited[0][0] = true;

        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int time = current[0];
            int moves = current[1];
            int row = current[2];
            int col = current[3];

            if (row == rows - 1 && col == cols - 1) return time;

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow < 0 || newCol < 0 || newRow >= rows || newCol >= cols || visited[newRow][newCol])
                    continue;

                visited[newRow][newCol] = true;

                int availableTime = moveTime[newRow][newCol];
                int waitTime = Math.max(time, availableTime);
                int moveCost = (moves % 2 == 0) ? 1 : 2;
                int arrivalTime = waitTime + moveCost;

                queue.offer(new int[]{arrivalTime, moves + 1, newRow, newCol});
            }
        }

        return -1;
    }
}
