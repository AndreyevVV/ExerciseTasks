package LeetCode.Top_Interview_150.Graph_BFS.Medium.Snakes_and_Ladders;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = n * n;
        boolean[] visited = new boolean[target];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[0] = true;

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                if (current == target)
                    return moves;

                for (int j = 1; j <= 6; j++) {
                    int next = current + j;
                    if (next > target)
                        break;

                    int[] coordinates = getCoordinates(next, n);
                    int nextRow = coordinates[0];
                    int nextCol = coordinates[1];

                    int value = board[nextRow][nextCol];

                    if (value != -1)
                        next = value;

                    if (!visited[next - 1]) {
                        queue.offer(next);
                        visited[next - 1] = true;
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    private int[] getCoordinates(int cell, int n) {
        int row = (n - 1) - (cell - 1) / n;
        int col;

        if (row % 2 == (n - 1) % 2)
            col = (cell - 1) % n;
        else
            col = (n - 1) - (cell - 1) % n;

        return new int[]{row, col};
    }
}
