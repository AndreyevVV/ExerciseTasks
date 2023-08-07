package LeetCode.LeetCode_75.Graphs_DFS.Medium.Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int minReorder(int n, int[][] connections) {
        ArrayList<int[]>[] adjVertices = new ArrayList[n];

        for (int i = 0; i < n; i++) adjVertices[i] = new ArrayList<>();

        for (int[] roads : connections) {
            adjVertices[roads[0]].add(new int[]{roads[1], 1});
            adjVertices[roads[1]].add(new int[]{roads[0], 0});
        }

        boolean[] visited = new boolean[n];

        return dfs(adjVertices, 0, visited);
    }

    private int dfs(List<int[]>[] adjVertices, int i, boolean[] visited) {
        visited[i] = true;
        int change = 0;
        for (int[] y : adjVertices[i]) {
            if (!visited[y[0]]) {
                change += dfs(adjVertices, y[0], visited) + y[1];
            }
        }
        return change;
    }
}
