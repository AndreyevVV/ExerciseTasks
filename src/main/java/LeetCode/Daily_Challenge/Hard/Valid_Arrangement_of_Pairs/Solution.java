package LeetCode.Daily_Challenge.Hard.Valid_Arrangement_of_Pairs;

import java.util.*;

public class Solution {

    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, Deque<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();

        for (int[] pair : pairs) {
            int start = pair[0], end = pair[1];
            graph.computeIfAbsent(start, k -> new ArrayDeque<>()).add(end);
            outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
            inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
        }

        int start = pairs[0][0];
        for (int key : outDegree.keySet()) {
            if (outDegree.getOrDefault(key, 0) > inDegree.getOrDefault(key, 0)) {
                start = key;
                break;
            }
        }

        List<int[]> result = new ArrayList<>();
        dfs(start, graph, result);

        Collections.reverse(result);
        return result.toArray(new int[result.size()][]);
    }

    private void dfs(int node, Map<Integer, Deque<Integer>> graph, List<int[]> result) {
        Deque<Integer> neighbors = graph.getOrDefault(node, new ArrayDeque<>());
        while (!neighbors.isEmpty()) {
            int next = neighbors.pollFirst();
            dfs(next, graph, result);
            result.add(new int[]{node, next});
        }
    }
}
