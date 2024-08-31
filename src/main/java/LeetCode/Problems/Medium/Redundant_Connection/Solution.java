package LeetCode.Problems.Medium.Redundant_Connection;

public class Solution {

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];

        // Initialize Union-Find structure
        for (int i = 1; i <= n; i++)
            parent[i] = i;

        // Traverse each edge
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // If the edge creates a cycle
            if (find(parent, u) == find(parent, v))
                return edge; // Return the edge that creates the cycle
            else
                union(parent, rank, u, v);
        }

        return new int[0];
    }

    // Find function with path compression
    private int find(int[] parent, int u) {
        if (parent[u] != u)
            parent[u] = find(parent, parent[u]);

        return parent[u];
    }

    // Union function with rank consideration
    private void union(int[] parent, int[] rank, int u, int v) {
        int rootU = find(parent, u);
        int rootV = find(parent, v);

        // Simply connect one root to the other with rank consideration
        if (rootU != rootV) {
            if (rank[rootU] > rank[rootV])
                parent[rootV] = rootU;
            else if (rank[rootU] < rank[rootV])
                parent[rootU] = rootV;
            else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }
}
