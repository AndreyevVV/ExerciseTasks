package LeetCode.Daily_Challenge.Hard.Sum_of_Distances_in_Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        int[] result = solution.sumOfDistancesInTree(n, edges);
        System.out.println(Arrays.toString(result));
    }

    List<List<Integer>> tree;
    int[] count;
    int[] ans;
    int n;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        tree = new ArrayList<>();
        count = new int[n];
        ans = new int[n];

        for (int i = 0; i < n; i++)
            tree.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        dfs(0, -1);
        dfs2(0, -1);

        return ans;
    }

    private void dfs(int node, int parent) {
        count[node] = 1;

        for (int child : tree.get(node)) {
            if (child == parent) continue;
            dfs(child, node);
            count[node] += count[child];
            ans[node] += ans[child] + count[child];
        }
    }

    private void dfs2(int node, int parent) {
        for (int child : tree.get(node)) {
            if (child == parent) continue;
            ans[child] = ans[node] - count[child] + (n - count[child]);
            dfs2(child, node);
        }
    }
}
