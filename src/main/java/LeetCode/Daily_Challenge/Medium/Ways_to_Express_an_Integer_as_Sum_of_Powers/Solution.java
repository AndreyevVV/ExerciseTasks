package LeetCode.Daily_Challenge.Medium.Ways_to_Express_an_Integer_as_Sum_of_Powers;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    static final int MOD = 1_000_000_007;
    Map<String, Integer> memo = new HashMap<>();

    public int numberOfWays(int n, int x) {
        return dfs(n, 1, x);
    }

    private int dfs(int target, int curr, int x) {
        if (target == 0) return 1;
        long pow = (long) Math.pow(curr, x);
        if (pow > target) return 0;

        String key = target + "," + curr;
        if (memo.containsKey(key)) return memo.get(key);

        int take = dfs((int)(target - pow), curr + 1, x) % MOD;
        int skip = dfs(target, curr + 1, x) % MOD;

        int res = (take + skip) % MOD;
        memo.put(key, res);
        return res;
    }
}
