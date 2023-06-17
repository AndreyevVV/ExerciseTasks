package LeetCode.LeetCode_75_Level_2.Day_19_Union_Find.Medium.Most_Stones_Removed_with_Same_Row_or_Column;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().removeStones(new int[][]{{0, 0}}));
    }

    public int removeStones(int[][] stones) {
        int length = stones.length;
        List<Integer>[] graph = new ArrayList[length];

        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                int[] stone1 = stones[i];
                int[] stone2 = stones[j];
                if (stone1[0] == stone2[0] || stone1[1] == stone2[1]) {
                    if (graph[i] == null) graph[i] = new ArrayList<>();
                    if (graph[j] == null) graph[j] = new ArrayList<>();
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }

        int deletedStones = 0;
        boolean[] visited = new boolean[length];

        for (int i = 0; i < length; i++) {
            if (visited[i]) continue;
            deletedStones += dfs(graph, visited, i);
        }
        return length - deletedStones;
    }

    private static int dfs(List<Integer>[] graph, boolean[] visited, int index) {
        if (visited[index]) return 0;
        visited[index] = true;

        if (graph[index] != null) {
            for (int n : graph[index])
                dfs(graph, visited, n);
        }
        return 1;
    }
}
