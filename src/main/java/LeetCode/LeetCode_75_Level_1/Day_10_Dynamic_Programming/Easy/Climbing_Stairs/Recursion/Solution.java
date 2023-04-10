package LeetCode.LeetCode_75_Level_1.Day_10_Dynamic_Programming.Easy.Climbing_Stairs.Recursion;

public class Solution {

    public int climbStairs(int n) {

        int count[] = new int[n + 1];

        for (int i = 0; i < n + 1; i++)
            count[i] = -1;
        return rec(n, count);
    }

    public int rec(int n, int count[]) {

        if (n < 4) return n;

        if (count[n] != -1) return count[n];

        count[n] = rec(n - 1, count) + rec(n - 2, count);
        return count[n];
    }
}
