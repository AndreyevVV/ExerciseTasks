package LeetCode.LeetCode_75_Level_2.Day_11_Graph_BFS_DFS.Hard.Bus_Routes;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numBusesToDestination(
                new int[][]{{7, 12}, {4, 5, 15}, {6}, {15, 19}, {9, 12, 13}}, 15, 12));
    }

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int answer = 0;

        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                map.computeIfAbsent(routes[i][j], key -> new ArrayList<>()).add(i);
            }
        }

        queue.offer(source);

        while (!queue.isEmpty()) {
            int length = queue.size();
            answer++;

            for (int i = 0; i < length; i++) {
                int currentNode = queue.poll();
                ArrayList<Integer> listOfAdjacentVertices = map.get(currentNode);
                for (int node : listOfAdjacentVertices) {
                    if (visited.contains(node)) continue;
                    visited.add(node);
                    for (int j = 0; j < routes[node].length; j++) {
                        if (routes[node][j] == target) return answer;
                        queue.offer(routes[node][j]);
                    }
                }
            }
        }
        return -1;
    }
}
