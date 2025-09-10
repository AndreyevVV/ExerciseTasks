package LeetCode.Daily_Challenge.Medium.Minimum_Number_of_People_to_Teach;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        
        List<Set<Integer>> knows = new ArrayList<>();
        for (int[] langArr : languages) {
            Set<Integer> set = new HashSet<>();
            for (int l : langArr) set.add(l);
            knows.add(set);
        }

        Set<Integer> needTeach = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0] - 1, v = f[1] - 1;
            boolean ok = false;
            for (int l : knows.get(u)) {
                if (knows.get(v).contains(l)) {
                    ok = true;
                    break;
                }
            }
            if (!ok) {
                needTeach.add(u);
                needTeach.add(v);
            }
        }

        if (needTeach.isEmpty()) return 0;

        int minTeach = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            int count = 0;
            for (int user : needTeach)
                if (knows.get(user).contains(lang)) count++;
            minTeach = Math.min(minTeach, needTeach.size() - count);
        }

        return minTeach;
    }
}
