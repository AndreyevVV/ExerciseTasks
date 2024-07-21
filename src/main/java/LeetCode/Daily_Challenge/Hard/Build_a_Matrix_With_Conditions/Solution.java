package LeetCode.Daily_Challenge.Hard.Build_a_Matrix_With_Conditions;

import java.util.*;

public class Solution {

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> rowOrder = topologicalSort(k, rowConditions);
        List<Integer> colOrder = topologicalSort(k, colConditions);

        if (rowOrder.isEmpty() || colOrder.isEmpty())
            return new int[0][0];

        Map<Integer, Integer> rowIndex = new HashMap<>();
        Map<Integer, Integer> colIndex = new HashMap<>();

        for (int i = 0; i < k; i++) {
            rowIndex.put(rowOrder.get(i), i);
            colIndex.put(colOrder.get(i), i);
        }

        int[][] matrix = new int[k][k];
        for (int i = 1; i <= k; i++) {
            int r = rowIndex.get(i);
            int c = colIndex.get(i);
            matrix[r][c] = i;
        }

        return matrix;
    }

    private List<Integer> topologicalSort(int k, int[][] conditions) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[k + 1];

        for (int[] condition : conditions) {
            graph.computeIfAbsent(condition[0], x -> new ArrayList<>()).add(condition[1]);
            inDegree[condition[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++)
            if (inDegree[i] == 0)
                queue.add(i);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            if (graph.containsKey(node)) {
                for (int neighbor : graph.get(node)) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0)
                        queue.add(neighbor);
                }
            }
        }

        return result.size() == k ? result : new ArrayList<>();
    }
}
