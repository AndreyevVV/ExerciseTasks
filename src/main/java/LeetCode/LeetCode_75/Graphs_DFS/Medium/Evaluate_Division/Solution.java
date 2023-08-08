package LeetCode.LeetCode_75.Graphs_DFS.Medium.Evaluate_Division;

import java.util.*;

public class Solution {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        Set<String> visited = new HashSet<>();

        int length = queries.size();
        double[] ans = new double[length];

        for (int i = 0; i < equations.size(); i++) {
            graph.putIfAbsent(equations.get(i).get(0), new HashMap<>());
            graph.putIfAbsent(equations.get(i).get(1), new HashMap<>());

            graph.get(equations.get(i).get(0)).put(equations.get(i).get(1), values[i]);
            graph.get(equations.get(i).get(1)).put(equations.get(i).get(0), 1 / values[i]);
        }
        for (int i = 0; i < length; i++) {
            visited.clear();
            ans[i] = dfs(graph, visited, queries.get(i).get(0), queries.get(i).get(1), 1.0);
        }
        return ans;
    }

    private double dfs(Map<String, Map<String, Double>> graph, Set<String> visited
            , String s, String target, double ratio) {
        if (!graph.containsKey(s)) return -1.0;
        if (s.equals(target)) return ratio;
        visited.add(s);

        for (Map.Entry<String, Double> edge : graph.get(s).entrySet()) {
            if (!visited.contains(edge.getKey())) {
                double ans = dfs(graph, visited, edge.getKey(), target, edge.getValue());
                if (ans != -1) return ratio * ans;
            }
        }
        return -1.0;
    }
}
