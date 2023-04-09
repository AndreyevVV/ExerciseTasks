package LeetCode.LeetCode_75_Level_1.Day_11_Dynamic_Programming.Min_Cost_Climbing_Stairs;

public class Solution {

    public int minCostClimbingStairs(int[] cost) {

        int[] cache = new int[cost.length + 1];
        cache[1] = cost[0];

        for (int i = 2; i < cache.length; i++) {

            int prev = cache[i - 2] + cost[i - 1];
            int next = cache[i - 1] + cost[i - 1];

            cache[i] = Math.min(prev, next);
        }
        return Math.min(cache[cache.length - 2], cache[cache.length - 1]);
    }
}
