package LeetCode.Daily_Challenge.Medium.Distribute_Candies_Among_Children_II;

public class Solution {

    public long distributeCandies(int n, int limit) {
        long total = comb(n + 2, 2);

        for (int i = 0; i < 3; i++)
            total -= comb(n - (limit + 1) + 2, 2);

        for (int i = 0; i < 3; i++)
            for (int j = i + 1; j < 3; j++)
                total += comb(n - 2 * (limit + 1) + 2, 2);


        total -= comb(n - 3 * (limit + 1) + 2, 2);

        return Math.max(0, total);
    }

    private long comb(int n, int k) {
        if (k > n || n < 0 || k < 0) return 0;
        long res = 1;
        for (int i = 1; i <= k; i++)
            res = res * (n - i + 1) / i;
        return res;
    }
}
