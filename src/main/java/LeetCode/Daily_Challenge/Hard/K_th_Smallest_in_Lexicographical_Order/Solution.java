package LeetCode.Daily_Challenge.Hard.K_th_Smallest_in_Lexicographical_Order;

public class Solution {

    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;

        while (k > 0) {
            long step = calcSteps(n, curr, curr + 1);
            if (step <= k) {
                curr++;
                k -= step;
            } else {
                curr *= 10;
                k--;
            }
        }

        return curr;
    }

    private long calcSteps(int n, long prefix, long nextPrefix) {
        long steps = 0;
        while (prefix <= n) {
            steps += Math.min(n + 1, nextPrefix) - prefix;
            prefix *= 10;
            nextPrefix *= 10;
        }
        return steps;
    }
}
