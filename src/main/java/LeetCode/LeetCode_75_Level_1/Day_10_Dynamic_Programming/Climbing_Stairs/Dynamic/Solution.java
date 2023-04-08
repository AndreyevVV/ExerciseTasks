package LeetCode.LeetCode_75_Level_1.Day_10_Dynamic_Programming.Climbing_Stairs.Dynamic;

public class Solution {

    public int climbStairs(int n) {

        if(n < 4) return n;

        int[] count = new int[n];

        count[0] = 1;
        count[1] = 2;

        for (int i = 2; i < n; i++ ) {
            count[i] = count[i - 1] + count[i - 2];
        }

        return count[n - 1];
    }
}
