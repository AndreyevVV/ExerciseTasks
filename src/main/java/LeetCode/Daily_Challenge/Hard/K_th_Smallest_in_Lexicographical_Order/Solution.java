package LeetCode.Daily_Challenge.Hard.K_th_Smallest_in_Lexicographical_Order;

public class Solution {

    public int findKthNumber(int n, int k) {
        long current = 1;
        int count = 1;

        while (count < k) {
            long steps = countSteps(current, current + 1, n);
            if (count + steps <= k) {
                current++;
                count += steps;
            } else {
                current *= 10;
                count++;
            }
        }

        return (int) current;
    }

    private long countSteps(long prefix, long nextPrefix, int n) {
        long steps = 0;
        while (prefix <= n) {
            steps += Math.min(n + 1L, nextPrefix) - prefix;
            prefix *= 10;
            nextPrefix *= 10;
        }
        return steps;
    }
}
