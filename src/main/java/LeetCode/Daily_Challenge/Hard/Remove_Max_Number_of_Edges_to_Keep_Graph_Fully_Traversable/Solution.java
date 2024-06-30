package LeetCode.Daily_Challenge.Hard.Remove_Max_Number_of_Edges_to_Keep_Graph_Fully_Traversable;

import java.util.Arrays;

public class Solution {

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind ufAlice = new UnionFind(n);
        UnionFind ufBob = new UnionFind(n);

        int edgesUsed = 0;

        Arrays.sort(edges, (a, b) -> b[0] - a[0]);

        for (int[] edge : edges) {
            int type = edge[0], u = edge[1] - 1, v = edge[2] - 1;

            if (type == 3) {
                boolean aliceMerged = ufAlice.union(u, v);
                boolean bobMerged = ufBob.union(u, v);
                if (aliceMerged || bobMerged)
                    edgesUsed++;
            } else if (type == 1) {
                if (ufAlice.union(u, v))
                    edgesUsed++;
            } else if (type == 2)
                if (ufBob.union(u, v))
                    edgesUsed++;
        }

        if (ufAlice.count() != 1 || ufBob.count() != 1)
            return -1;

        return edges.length - edgesUsed;
    }

    class UnionFind {
        private int[] parent;
        private int[] rank;
        private int count;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int u) {
            if (parent[u] != u)
                parent[u] = find(parent[u]);
            return parent[u];
        }

        public boolean union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);

            if (rootU == rootV)
                return false;

            if (rank[rootU] > rank[rootV])
                parent[rootV] = rootU;
            else if (rank[rootU] < rank[rootV])
                parent[rootU] = rootV;
            else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }

            count--;
            return true;
        }

        public int count() {
            return count;
        }
    }
}
