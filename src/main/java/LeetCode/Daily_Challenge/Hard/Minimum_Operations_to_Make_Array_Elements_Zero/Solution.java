package LeetCode.Daily_Challenge.Hard.Minimum_Operations_to_Make_Array_Elements_Zero;

public class Solution {

    private static final long[] prefixExp = new long[18];

    private static long totalSteps(int x) {
        if (x == 0) return 0;

        int log4 = (31 - Integer.numberOfLeadingZeros(x)) >> 1;

        int remainder = x - (1 << (log4 << 1));

        return prefixExp[log4] + (long) remainder * (log4 + 1);
    }

    public static long minOperations(int[][] queries) {
        prefixExp[0] = 1;
        for (int i = 1; i < prefixExp.length; i++)
            prefixExp[i] = prefixExp[i - 1] + 3L * i * (1L << (2 * (i - 1))) + 1;

        long result = 0;
        for (int[] q : queries) {
            int l = q[0] - 1;
            int r = q[1];
            long steps = totalSteps(r) - totalSteps(l);
            result += (steps + 1) >> 1;
        }
        return result;
    }
}
