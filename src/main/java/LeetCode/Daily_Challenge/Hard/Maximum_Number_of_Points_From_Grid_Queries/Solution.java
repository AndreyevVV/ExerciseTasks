package LeetCode.Daily_Challenge.Hard.Maximum_Number_of_Points_From_Grid_Queries;

import java.util.*;

public class Solution {

    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length, n = grid[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int[] sortedQueries = queries.clone();
        Arrays.sort(sortedQueries);

        Map<Integer, Integer> queryResults = new HashMap<>();
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        int count = 0;

        for (int q : sortedQueries) {
            while (!pq.isEmpty() && pq.peek()[0] < q) {
                int[] cell = pq.poll();
                int r = cell[1], c = cell[2];

                count++;

                for (int[] d : directions) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                        pq.offer(new int[]{grid[nr][nc], nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
            queryResults.put(q, count);
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++)
            answer[i] = queryResults.get(queries[i]);
        return answer;
    }
}
