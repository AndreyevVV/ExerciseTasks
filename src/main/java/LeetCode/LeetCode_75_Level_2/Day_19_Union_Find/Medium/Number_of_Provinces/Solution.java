package LeetCode.LeetCode_75_Level_2.Day_19_Union_Find.Medium.Number_of_Provinces;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int findCircleNum(int[][] isConnected) {
        int length = isConnected.length, answer = 0;
        boolean[] visited = new boolean[length];

        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                dfs(i, isConnected, visited);
                answer++;
            }
        }
        return answer;
    }

    private void dfs(int from, int[][] isConnected, boolean[] visited) {
        visited[from] = true;
        for (int i = 0; i < isConnected[from].length; i++) {
            if (!visited[i] && isConnected[from][i] == 1) {
                dfs(i, isConnected, visited);
            }
        }
    }
}
