package LeetCode.LeetCode_75.Graphs_BFS.Medium.Nearest_Exit_from_Entrance_in_Maze;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().nearestExit(
                new char[][]{{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}}, new int[]{1, 2}));
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        if (maze == null || maze.length == 0) return 0;

        int sr = maze.length;
        int sc = maze[0].length;
        char empty = '.';
        char visited = 'v';

        Queue<int[]> emptyCellsQueue = new LinkedList<>();
        emptyCellsQueue.offer(entrance);
        maze[entrance[0]][entrance[1]] = visited;

        int minPath = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!emptyCellsQueue.isEmpty()) {
            int size = emptyCellsQueue.size();
            minPath++;

            for (int i = 0; i < size; i++) {
                int[] curr = emptyCellsQueue.poll();

                for (int[] dir : directions) {
                    int newRow = curr[0] + dir[0];
                    int newCol = curr[1] + dir[1];

                    if (newRow >= 0 && newRow < sr && newCol >= 0 && newCol < sc
                            && maze[newRow][newCol] == empty && maze[newRow][newCol] != visited) {
                        maze[newRow][newCol] = visited;
                        if (newRow == 0 || newRow == sr - 1 || newCol == 0 || newCol == sc - 1) return minPath;
                        emptyCellsQueue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }
        return -1;
    }
}
