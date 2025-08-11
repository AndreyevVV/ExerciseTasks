package LeetCode.Daily_Challenge.Medium.Range_Product_Queries_of_Powers;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    public int[] productQueries(int n, int[][] queries) {
        final int MOD = 1_000_000_007;
        List<Integer> powers = new ArrayList<>();

        for (int i = 0; i < 31; i++)
            if ((n & (1 << i)) != 0)
                powers.add(1 << i);

        int[] ans = new int[queries.length];

        for (int qi = 0; qi < queries.length; qi++) {
            int l = queries[qi][0], r = queries[qi][1];
            long prod = 1;
            
            for (int i = l; i <= r; i++)
                prod = (prod * powers.get(i)) % MOD;
            ans[qi] = (int) prod;
        }
        return ans;
    }
}
