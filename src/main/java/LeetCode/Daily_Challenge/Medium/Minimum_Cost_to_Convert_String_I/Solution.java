package LeetCode.Daily_Challenge.Medium.Minimum_Cost_to_Convert_String_I;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String source = "abc";
        String target = "bcd";
        char[] original = {'a', 'b', 'c'};
        char[] changed = {'b', 'c', 'd'};
        int[] cost = {1, 2, 3};
        System.out.println(sol.minimumCost(source, target, original, changed, cost)); // Output: 6
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = source.length();
        if (n != target.length())
            return -1;

        int ALPHABET_SIZE = 26;
        int[][] dist = new int[ALPHABET_SIZE][ALPHABET_SIZE];
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE / 2);
            dist[i][i] = 0;
        }

        for (int i = 0; i < original.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            dist[from][to] = Math.min(dist[from][to], cost[i]);
        }

        // Floyd Warshall algorithm
        for (int k = 0; k < ALPHABET_SIZE; k++)
            for (int i = 0; i < ALPHABET_SIZE; i++)
                for (int j = 0; j < ALPHABET_SIZE; j++)
                    if (dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

        long totalCost = 0;
        for (int i = 0; i < n; i++) {
            char s = source.charAt(i);
            char t = target.charAt(i);

            if (s == t)
                continue;

            int from = s - 'a';
            int to = t - 'a';

            if (dist[from][to] == Integer.MAX_VALUE / 2)
                return -1;

            totalCost += dist[from][to];
        }

        return totalCost;
    }
}
