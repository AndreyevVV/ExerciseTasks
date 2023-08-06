package LeetCode.LeetCode_75.Graphs_DFS.Medium.Keys_and_Rooms.DFS_solution;

import java.util.List;

public class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int length = rooms.size(), answer = 0;
        boolean[] visited = new boolean[length];
        answer = dfs(rooms, visited, 0);
        return answer == length;
    }

    private int dfs(List<List<Integer>> rooms, boolean[] visited, int i) {
        if(visited[i])return 0;
        visited[i] = true;
        int answer = 1;
        List<Integer> keys = rooms.get(i);

        for(Integer next : keys){
            answer +=dfs(rooms, visited, next);
        }
        return answer;
    }
}
