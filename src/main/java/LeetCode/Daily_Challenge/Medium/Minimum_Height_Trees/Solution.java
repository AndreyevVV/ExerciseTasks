package LeetCode.Daily_Challenge.Medium.Minimum_Height_Trees;

import java.util.*;

public class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1)
            return Collections.singletonList(0);

        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> degrees = new HashMap<>();

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            graph.putIfAbsent(node1, new ArrayList<>());
            graph.putIfAbsent(node2, new ArrayList<>());
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);

            degrees.put(node1, degrees.getOrDefault(node1, 0) + 1);
            degrees.put(node2, degrees.getOrDefault(node2, 0) + 1);
        }

        Queue<Integer> leaves = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : degrees.entrySet())
            if (entry.getValue() == 1)
                leaves.offer(entry.getKey());

        while (n > 2) {
            int leavesSize = leaves.size();
            n -= leavesSize;
            for (int i = 0; i < leavesSize; i++) {
                int leaf = leaves.poll();
                List<Integer> neighbors = graph.get(leaf);
                if (neighbors != null) {
                    for (int neighbor : neighbors) {
                        int degree = degrees.get(neighbor) - 1;
                        degrees.put(neighbor, degree);
                        if (degree == 1)
                            leaves.offer(neighbor);
                    }
                }
            }
        }

        List<Integer> minHeightRoots = new ArrayList<>();
        while (!leaves.isEmpty())
            minHeightRoots.add(leaves.poll());

        return minHeightRoots;
    }
}
