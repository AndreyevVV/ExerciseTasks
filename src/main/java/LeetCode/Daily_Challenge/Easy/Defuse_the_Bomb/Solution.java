package LeetCode.Daily_Challenge.Easy.Defuse_the_Bomb;

public class Solution {

    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        if (k == 0)
            return result;

        int step = Math.abs(k);
        boolean isForward = k > 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 1; j <= step; j++) {
                int index = isForward ? (i + j) % n : (i - j + n) % n;
                sum += code[index];
            }
            result[i] = sum;
        }

        return result;
    }
}
