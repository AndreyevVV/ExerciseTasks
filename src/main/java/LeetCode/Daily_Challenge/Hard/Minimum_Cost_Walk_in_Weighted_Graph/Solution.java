package LeetCode.Daily_Challenge.Hard.Minimum_Cost_Walk_in_Weighted_Graph;

class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] queries) {
        int[] result = new int[queries.length];
        DisjointSet ds = new DisjointSet(n);

        for (int[] edge : edges)
            ds.union(edge[0], edge[1], edge[2]);

        for (int i = 0; i < queries.length; i++)
            result[i] = ds.find(queries[i][0], queries[i][1]);

        return result;
    }

    static class DisjointSet {
        private int[] parent, size, cost;

        public DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];
            cost = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                cost[i] = 0xFFFFF;
            }
        }

        public int findParent(int x) {
            if (x != parent[x])
                parent[x] = findParent(parent[x]);
            return parent[x];
        }

        public int find(int u, int v) {
            int rootU = findParent(u);
            int rootV = findParent(v);
            return (rootU == rootV) ? cost[rootU] : -1;
        }

        public void union(int u, int v, int weight) {
            int rootU = findParent(u);
            int rootV = findParent(v);
            int newCost = cost[rootU] & cost[rootV] & weight;

            if (rootU == rootV) {
                cost[rootU] = newCost;
                return;
            }

            if (size[rootU] > size[rootV]) {
                parent[rootV] = rootU;
                size[rootU] += size[rootV];
                cost[rootU] = newCost;
            } else {
                parent[rootU] = rootV;
                size[rootV] += size[rootU];
                cost[rootV] = newCost;
            }
        }
    }
}
