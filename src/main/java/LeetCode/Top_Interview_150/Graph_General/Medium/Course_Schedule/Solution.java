package LeetCode.Top_Interview_150.Graph_General.Medium.Course_Schedule;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        for (int[] prereq : prerequisites)
            graph.get(prereq[0]).add(prereq[1]);

        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && hasCycle(graph, visited, i))
                return false;
        }
        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, int[] visited, int course) {
        if (visited[course] == 1)
            return true;

        if (visited[course] == 2)
            return false;

        visited[course] = 1;

        for (int prereq : graph.get(course)) {
            if (hasCycle(graph, visited, prereq))
                return true;
        }

        visited[course] = 2;
        return false;
    }
}
