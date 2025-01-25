package LeetCode.Daily_Challenge.Medium.Make_Lexicographically_Smallest_Array_by_Swapping_Elements;

import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        UnionFind uf = new UnionFind(sortedNums);

        for (int i = 1; i < sortedNums.length; i++)
            if (sortedNums[i] - sortedNums[i - 1] <= limit)
                uf.union(sortedNums[i], sortedNums[i - 1]);

        Map<Integer, Queue<Integer>> groupMap = new HashMap<>();
        for (int num : sortedNums) {
            int root = uf.find(num);
            groupMap.computeIfAbsent(root, k -> new PriorityQueue<>()).offer(num);
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int root = uf.find(nums[i]);
            result[i] = groupMap.get(root).poll();
        }

        return result;
    }

    static class UnionFind {
        private final Map<Integer, Integer> parent;

        public UnionFind(int[] nums) {
            parent = new HashMap<>();
            for (int num : nums)
                parent.put(num, num);
        }

        public int find(int x) {
            if (parent.get(x) != x)
                parent.put(x, find(parent.get(x)));
            return parent.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY)
                parent.put(rootY, rootX);
        }
    }
}
