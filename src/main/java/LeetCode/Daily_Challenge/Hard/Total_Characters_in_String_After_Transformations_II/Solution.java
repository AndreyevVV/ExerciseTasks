package LeetCode.Daily_Challenge.Hard.Total_Characters_in_String_After_Transformations_II;

import java.util.List;

public class Solution {

    private static final int MOD = 1_000_000_007;
    private static final int L = 26;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int[][] T = new int[L][L];

        for (int i = 0; i < L; i++)
            for (int j = 1; j <= nums.get(i); j++)
                T[(i + j) % L][i] = 1;

        int[][] T_pow = matrixPow(T, t);

        int[] freq = new int[L];
        for (char ch : s.toCharArray())
            freq[ch - 'a']++;

        int result = 0;
        for (int i = 0; i < L; i++) {
            long sum = 0;
            for (int j = 0; j < L; j++)
                sum = (sum + (long) T_pow[i][j] * freq[j]) % MOD;
            result = (int) ((result + sum) % MOD);
        }

        return result;
    }

    private int[][] matrixMult(int[][] A, int[][] B) {
        int[][] C = new int[L][L];
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                long sum = 0;
                for (int k = 0; k < L; k++)
                    sum = (sum + (long) A[i][k] * B[k][j]) % MOD;
                C[i][j] = (int) sum;
            }
        }
        return C;
    }

    private int[][] matrixPow(int[][] base, int power) {
        int[][] result = identityMatrix();
        int[][] curr = copyMatrix(base);

        while (power > 0) {
            if ((power & 1) == 1)
                result = matrixMult(result, curr);
            curr = matrixMult(curr, curr);
            power >>= 1;
        }

        return result;
    }

    private int[][] identityMatrix() {
        int[][] I = new int[L][L];
        for (int i = 0; i < L; i++)
            I[i][i] = 1;
        return I;
    }

    private int[][] copyMatrix(int[][] M) {
        int[][] copy = new int[L][L];
        for (int i = 0; i < L; i++)
            System.arraycopy(M[i], 0, copy[i], 0, L);
        return copy;
    }
}
