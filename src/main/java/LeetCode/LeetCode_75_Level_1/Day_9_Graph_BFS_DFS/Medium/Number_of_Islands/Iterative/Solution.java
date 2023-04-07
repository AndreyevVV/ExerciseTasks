package LeetCode.LeetCode_75_Level_1.Day_9_Graph_BFS_DFS.Medium.Number_of_Islands.Iterative;

import java.util.Stack;

class Solution {
    public int numIslands(char[][] grid) {

        int sr = grid.length;
        int sc = grid[0].length;

        int[][] visited = new int[sr][sc];

        int count = 0;

        for (int i = 0; i < sr; i++) {
            for (int j = 0; j < sc; j++) {

                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid, visited);
                }
            }
        }
        return count;
    }

    public void dfs(int sr, int sc, char[][] grid, int[][] visited) {

        visited[sr][sc] = 1;

        Stack<Pair> q = new Stack<>();
        q.push(new Pair(sr, sc));

        int n = grid.length;
        int m = grid[0].length;

        int[] delRow = {-1, 1, 0, 0};
        int[] delCol = {0, 0, 1, -1};

        while (!q.isEmpty()) {

            int nrow = q.peek().first;
            int ncol = q.peek().second;
            q.pop();

            for (int i = 0; i < 4; i++) {

                int deltaRow = nrow + delRow[i];
                int deltaCol = ncol + delCol[i];

                if (deltaRow >= 0 && deltaRow < n && deltaCol >= 0 && deltaCol < m &&
                        visited[deltaRow][deltaCol] == 0 && grid[deltaRow][deltaCol] == '1') {

                    visited[deltaRow][deltaCol] = 1;
                    q.add(new Pair(deltaRow, deltaCol));
                }
            }
        }
    }

    static class Pair {
        int first;
        int second;

        Pair(int fst, int scnd) {
            this.first = fst;
            this.second = scnd;
        }
    }
}
