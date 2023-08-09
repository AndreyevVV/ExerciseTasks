package LeetCode.LeetCode_75.Graphs_BFS.Medium.Rotting_Oranges.BFS_Solution;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int orangesRotting(int[][] grid) {
        int countFresh = 0;

        if (grid == null || grid.length == 0) return 0;

        int sr = grid.length;
        int sc = grid[0].length;

        Queue<int[]> rottenQueue = new LinkedList<>();

        for (int i = 0; i < sr; i++) {
            for (int j = 0; j < sc; j++) {
                if (grid[i][j] == 2) rottenQueue.offer(new int[]{i, j});
                else if (grid[i][j] == 1) countFresh++;
            }
        }

        if (countFresh == 0) return 0;

        int cnt = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!rottenQueue.isEmpty()) {
            int size = rottenQueue.size();
            cnt++;

            for (int i = 0; i < size; i++) {
                int[] curr = rottenQueue.poll();

                for (int[] dir : directions) {
                    int newRow = curr[0] + dir[0];
                    int newCol = curr[1] + dir[1];

                    if (newRow >= 0 && newRow < sr && newCol >= 0 && newCol < sc && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        rottenQueue.offer(new int[]{newRow, newCol});
                        countFresh--;
                    }
                }
            }
        }
        return countFresh == 0 ? cnt - 1 : -1;
    }
}
