package LeetCode.Daily_Challenge.Hard.Minimum_Score_After_Removals_on_a_Tree;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    int[] nums;
    List<List<Integer>> graph;
    int[] subtreeXor, in, out;
    int timer = 0, totalXor;

    public int minimumScore(int[] nums, int[][] edges) {
        this.nums = nums;
        int n = nums.length;
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        subtreeXor = new int[n];
        in = new int[n];
        out = new int[n];

        totalXor = 0;
        for (int v : nums) totalXor ^= v;

        dfs(0, -1);

        List<Integer> nodes = new ArrayList<>();
        for (int i = 1; i < n; i++) nodes.add(i);

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < nodes.size(); i++) {
            int a = nodes.get(i);
            for (int j = i + 1; j < nodes.size(); j++) {
                int b = nodes.get(j);

                int xor1 = subtreeXor[a];
                int xor2 = subtreeXor[b];
                int xor3;

                if (isAncestor(a, b)) {
                    xor2 = subtreeXor[b];
                    xor3 = totalXor ^ xor1;
                    xor1 ^= xor2;
                } else if (isAncestor(b, a)) {
                    xor1 = subtreeXor[a];
                    xor3 = totalXor ^ xor2;
                    xor2 ^= xor1;
                } else
                    xor3 = totalXor ^ xor1 ^ xor2;

                int maxVal = Math.max(xor1, Math.max(xor2, xor3));
                int minVal = Math.min(xor1, Math.min(xor2, xor3));
                res = Math.min(res, maxVal - minVal);
            }
        }

        return res;
    }

    private void dfs(int u, int parent) {
        in[u] = ++timer;
        int xor = nums[u];
        for (int v : graph.get(u)) {
            if (v == parent) continue;
            dfs(v, u);
            xor ^= subtreeXor[v];
        }
        subtreeXor[u] = xor;
        out[u] = timer;
    }

    private boolean isAncestor(int a, int b) {
        return in[a] <= in[b] && out[b] <= out[a];
    }
}
