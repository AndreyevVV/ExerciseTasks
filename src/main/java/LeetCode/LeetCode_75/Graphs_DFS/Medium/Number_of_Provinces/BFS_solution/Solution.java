package LeetCode.LeetCode_75.Graphs_DFS.Medium.Number_of_Provinces.BFS_solution;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int findCircleNum(int[][] isConnected) {
        int length = isConnected.length, answer = 0;
        boolean[] visited = new boolean[length];

        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                bfs(i, isConnected, visited);
                answer++;
            }
        }
        return answer;
    }

    private void bfs(int from, int[][] isConnected, boolean[] visited) {
        visited[from] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(from);
        while (!queue.isEmpty()) {
            int j = queue.poll();
            for (int i = 0; i < isConnected[j].length; i++) {
                if (!visited[i] && isConnected[j][i] == 1) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
