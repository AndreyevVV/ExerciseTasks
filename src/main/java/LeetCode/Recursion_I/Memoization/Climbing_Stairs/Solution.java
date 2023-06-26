package LeetCode.Recursion_I.Memoization.Climbing_Stairs;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {
        if (cache.containsKey(n)) return cache.get(n);

        int result;
        if (n < 4) result = n;
        else result = climbStairs(n - 1) + climbStairs(n - 2);

        cache.put(n, result);
        return result;
    }
}
