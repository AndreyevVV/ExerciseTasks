package LeetCode.Daily_Challenge.Medium.Maximize_the_Number_of_Target_Nodes_After_Connecting_Trees_I;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        List<List<Integer>> adj1 = buildTree(edges1);
        List<List<Integer>> adj2 = buildTree(edges2);

        int maxReachTree2 = 0;
        for (int i = 0; i < adj2.size(); i++)
            maxReachTree2 = Math.max(maxReachTree2, dfs(adj2, i, -1, k - 1));

        int[] result = new int[adj1.size()];
        for (int i = 0; i < adj1.size(); i++)
            result[i] = dfs(adj1, i, -1, k) + maxReachTree2;

        return result;
    }

    private List<List<Integer>> buildTree(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        return adj;
    }

    private int dfs(List<List<Integer>> adj, int u, int parent, int k) {
        if (k < 0) return 0;
        int count = 1; // текущий узел
        for (int neighbor : adj.get(u))
            if (neighbor != parent)
                count += dfs(adj, neighbor, u, k - 1);

        return count;
    }
}
