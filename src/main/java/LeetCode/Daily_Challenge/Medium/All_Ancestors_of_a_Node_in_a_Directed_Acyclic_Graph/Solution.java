package LeetCode.Daily_Challenge.Medium.All_Ancestors_of_a_Node_in_a_Directed_Acyclic_Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] edge : edges)
            graph.get(edge[1]).add(edge[0]);

        List<List<Integer>> ancestors = new ArrayList<>();
        for (int i = 0; i < n; i++)
            ancestors.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            findAncestors(graph, ancestors, visited, i, i);
        }

        for (List<Integer> ancestor : ancestors)
            Collections.sort(ancestor);

        return ancestors;
    }

    private static void findAncestors(List<List<Integer>> graph, List<List<Integer>> ancestors
            , boolean[] visited, int node, int target) {
        for (int ancestor : graph.get(node)) {
            if (!visited[ancestor]) {
                ancestors.get(target).add(ancestor);
                visited[ancestor] = true;
                findAncestors(graph, ancestors, visited, ancestor, target);
            }
        }
    }
}
