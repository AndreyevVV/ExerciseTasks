package LeetCode.Daily_Challenge.Hard.Count_Number_of_Balanced_Permutations;

import java.util.Arrays;

public class Solution {
    static final int MOD = 1_000_000_007;
    int[][][] dp;
    int[] digitCount = new int[10], suffixSum = new int[10], suffixCount = new int[10];
    long[] productPermutations = new long[11];
    int[][] combinations = new int[81][81];

    void buildCombinations() {
        for (int i = 0; i <= 80; i++) {
            combinations[i][0] = combinations[i][i] = 1;
            for (int j = 1; j < i; j++)
                combinations[i][j] = (combinations[i - 1][j - 1] + combinations[i - 1][j]) % MOD;
        }
    }

    long dfs(int digit, int sum, int count) {
        if (sum == 0 && count == 0) return productPermutations[digit];
        if (digit == 10 || sum > suffixSum[digit] || count > suffixCount[digit]) return 0;
        if (dp[digit][sum][count] != -1) return dp[digit][sum][count];

        long res = 0;
        int remainingSum = sum;
        for (int used = 0, left = digitCount[digit]; used <= digitCount[digit] && remainingSum >= 0 && count >= used; used++, left--, remainingSum -= digit) {
            if (left > suffixCount[digit] - count) continue;
            long part1 = dfs(digit + 1, remainingSum, count - used) * combinations[count][used] % MOD;
            long part2 = combinations[suffixCount[digit] - count][left];
            res = (res + part1 * part2) % MOD;
        }

        return dp[digit][sum][count] = (int) res;
    }

    public int countBalancedPermutations(String num) {
        int totalSum = 0;
        int n = num.length();

        for (char ch : num.toCharArray()) {
            int d = ch - '0';
            digitCount[d]++;
            totalSum += d;
        }

        if ((totalSum & 1) != 0) return 0;

        buildCombinations();

        productPermutations[10] = 1;
        int sumSoFar = 0, countSoFar = 0;
        for (int i = 9; i >= 0; i--) {
            sumSoFar += i * digitCount[i];
            countSoFar += digitCount[i];
            suffixSum[i] = sumSoFar;
            suffixCount[i] = countSoFar;
            productPermutations[i] = productPermutations[i + 1] * combinations[suffixCount[i]][digitCount[i]] % MOD;
        }

        dp = new int[10][361][41];
        for (int[][] level : dp)
            for (int[] row : level)
                Arrays.fill(row, -1);

        return (int) dfs(0, totalSum / 2, n / 2);
    }
}
