package LeetCode.LeetCode_75.Graphs_DFS.Medium.Keys_and_Rooms.BFS_solution;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int length = rooms.size(), answer = 0;

        boolean[] visited = new boolean[length];
        visited[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int from = queue.poll();
                answer++;
                for (int next : rooms.get(from)) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
                size--;
            }
        }
        return answer == length;
    }
}
