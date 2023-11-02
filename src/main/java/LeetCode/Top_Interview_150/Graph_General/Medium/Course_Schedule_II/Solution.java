package LeetCode.Top_Interview_150.Graph_General.Medium.Course_Schedule_II;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        for (int[] prereq : prerequisites)
            graph.get(prereq[0]).add(prereq[1]);

        int[] visited = new int[numCourses];

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && !hasNoCycle(graph, visited, answer, i))
                return new int[]{};
        }

        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = answer.get(i);
        }
        return result;
    }

    private boolean hasNoCycle(List<List<Integer>> graph, int[] visited, List<Integer> answer, int course) {
        if (visited[course] == 1)
            return false;

        if (visited[course] == 2)
            return true;

        visited[course] = 1;

        for (int prereq : graph.get(course)) {
            if (!hasNoCycle(graph, visited, answer, prereq))
                return false;
        }

        visited[course] = 2;
        answer.add(course);
        return true;
    }
}
