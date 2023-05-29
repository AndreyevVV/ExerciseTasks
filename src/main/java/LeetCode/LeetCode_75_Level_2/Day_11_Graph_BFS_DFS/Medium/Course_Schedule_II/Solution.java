package LeetCode.LeetCode_75_Level_2.Day_11_Graph_BFS_DFS.Medium.Course_Schedule_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<Integer> ans = new ArrayList<>();

        HashSet<Integer> s = new HashSet<>();
        HashMap<Integer, List<Integer>> listOfAdjacentVertices = new HashMap<>();

        for (int[] pre : prerequisites) {
            int c = pre[0];
            int prereqCourse = pre[1];
            listOfAdjacentVertices.putIfAbsent(c, new ArrayList<>());
            listOfAdjacentVertices.get(c).add(prereqCourse);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!s.contains(i)) {
                if (!dfs(s, i, listOfAdjacentVertices, new HashSet<>(), ans)) {
                    return new int[]{};
                }
            }
        }

        int[] result = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            result[i] = ans.get(i);
        }
        return result;
    }

    public boolean dfs(HashSet<Integer> s, int i, HashMap<Integer, List<Integer>> adj, HashSet<Integer> curr,
                       List<Integer> ans) {

        if (s.contains(i)) {
            return true;
        }

        if (!adj.containsKey(i)) {
            ans.add(i);
            s.add(i);
            return true;
        }

        curr.add(i);

        for (int pre : adj.get(i)) {
            if (curr.contains(pre) || !dfs(s, pre, adj, curr, ans)) {
                return false;
            }
        }

        curr.remove(i);
        ans.add(i);
        s.add(i);
        return true;
    }
}
