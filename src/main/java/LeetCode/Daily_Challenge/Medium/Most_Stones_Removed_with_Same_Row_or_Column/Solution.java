package LeetCode.Daily_Challenge.Medium.Most_Stones_Removed_with_Same_Row_or_Column;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind(20001);

        for (int[] stone : stones) {
            int x = stone[0];
            int y = stone[1] + 10001;
            uf.union(x, y);
        }

        Set<Integer> components = new HashSet<>();

        for (int[] stone : stones)
            components.add(uf.find(stone[0]));

        return stones.length - components.size();
    }

    class UnionFind {
        private int[] parent;

        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++)
                parent[i] = i;
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
            }
        }

        public int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }
    }
}
