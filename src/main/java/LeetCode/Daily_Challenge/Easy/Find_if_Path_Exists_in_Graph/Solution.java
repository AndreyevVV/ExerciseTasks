package LeetCode.Daily_Challenge.Easy.Find_if_Path_Exists_in_Graph;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        return dfs(graph, visited, source, destination);
    }

    private boolean dfs(List<List<Integer>> graph, boolean[] visited, int source, int destination) {
        if (source == destination)
            return true;

        visited[source] = true;

        for (int neighbor : graph.get(source))
            if (!visited[neighbor])
                if (dfs(graph, visited, neighbor, destination))
                    return true;

        return false;
    }
}
