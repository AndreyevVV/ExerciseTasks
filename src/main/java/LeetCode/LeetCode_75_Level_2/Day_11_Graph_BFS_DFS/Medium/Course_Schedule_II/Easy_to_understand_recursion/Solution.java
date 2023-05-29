package LeetCode.LeetCode_75_Level_2.Day_11_Graph_BFS_DFS.Medium.Course_Schedule_II.Easy_to_understand_recursion;

import java.util.ArrayList;

public class Solution {
    int idx = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];

        // Create Graph
        ArrayList[] adjList = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) adjList[i] = new ArrayList<Integer>();
        for (int[] pair : prerequisites) adjList[pair[0]].add(pair[1]);

        // Perform DFS cycle search
        int[] visited = new int[numCourses]; // 0 - unvisited, 1 - visited-incomplete, 2 - complete
        for (int i = 0; i < numCourses; i++)
            if (dfs(i, visited, adjList, res)) return new int[0];
        return res;
    }

    // DFS: returns true if the course is completed
    private boolean dfs(int i, int[] visited, ArrayList<Integer>[] adjList, int[] res) {
        if (visited[i] == 2) return false;
        for (int req : adjList[i]) {
            if (visited[req] == 0) {
                visited[i] = 1;
                if (dfs(req, visited, adjList, res)) return true;
            } else if (visited[req] == 1) return true;
        }
        visited[i] = 2;
        res[idx++] = i;
        return false;
    }
}
