package LeetCode.Daily_Challenge.Hard.Find_All_People_With_Secret;

import java.util.*;

public class Solution {

    public List<Integer> findAllPeople(int n, int[][] meetings, int first) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[2]));

        UnionFind unionFind = new UnionFind(n);
        unionFind.union(0, first);

        int i = 0;

        while (i < meetings.length) {
            int curTime = meetings[i][2];
            Set<Integer> pool = new HashSet<>();

            while (i < meetings.length && curTime == meetings[i][2]) {
                int[] currentMeeting = meetings[i];
                unionFind.union(currentMeeting[0], currentMeeting[1]);
                pool.add(currentMeeting[0]);
                pool.add(currentMeeting[1]);
                i++;
            }

            for (int j : pool) if (!unionFind.connected(0, j)) unionFind.reset(j);
        }

        List<Integer> ans = new ArrayList<>();

        for (int k = 0; k < n; k++) if (unionFind.connected(k, 0)) ans.add(k);

        return ans;
    }

    class UnionFind {
        int[] parent, rating;

        public UnionFind(int n) {
            parent = new int[n];
            rating = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ)
                return;

            if (rating[rootP] < rating[rootQ]) {
                parent[rootP] = rootQ;
            } else {
                parent[rootQ] = rootP;
                rating[rootP]++;
            }
        }

        public int find(int p) {
            while (parent[p] != p) {
                p = parent[parent[p]];
            }
            return p;
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public void reset(int p) {
            parent[p] = p;
            rating[p] = 0;
        }
    }
}
