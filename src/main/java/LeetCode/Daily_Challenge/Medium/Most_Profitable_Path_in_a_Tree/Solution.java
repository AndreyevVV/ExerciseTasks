package LeetCode.Daily_Challenge.Medium.Most_Profitable_Path_in_a_Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
        }

        Map<Integer, Integer> bobTime = new HashMap<>();
        findBobPath(bob, -1, 0, graph, bobTime);

        return dfsAlice(0, -1, 0, 0, graph, bobTime, amount);
    }

    private boolean findBobPath(int node, int parent, int time, Map<Integer, List<Integer>> graph,
                                Map<Integer, Integer> bobTime) {
        bobTime.put(node, time);
        if (node == 0) return true;

        for (int neighbor : graph.get(node))
            if (neighbor != parent && findBobPath(neighbor, node, time + 1, graph, bobTime))
                return true;

        bobTime.remove(node);
        return false;
    }

    private int dfsAlice(int node, int parent, int time, int income, Map<Integer, List<Integer>> graph,
                         Map<Integer, Integer> bobTime, int[] amount) {
        if (!bobTime.containsKey(node) || bobTime.get(node) > time)
            income += amount[node];
        else if (bobTime.get(node) == time)
            income += amount[node] / 2;

        if (graph.get(node).size() == 1 && node != 0) return income;

        int maxIncome = Integer.MIN_VALUE;

        for (int neighbor : graph.get(node))
            if (neighbor != parent)
                maxIncome = Math.max(maxIncome, dfsAlice(neighbor, node, time + 1, income,
                        graph, bobTime, amount));

        return maxIncome;
    }
}
