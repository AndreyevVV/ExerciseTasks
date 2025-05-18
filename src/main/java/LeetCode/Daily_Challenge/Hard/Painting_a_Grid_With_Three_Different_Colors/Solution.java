package LeetCode.Daily_Challenge.Hard.Painting_a_Grid_With_Three_Different_Colors;

import java.util.*;

public class Solution {

    static final int MOD = 1_000_000_007;
    List<int[]> validCols = new ArrayList<>();
    Map<String, Integer> memo = new HashMap<>();

    public int colorTheGrid(int m, int n) {
        generateValidColumns(m, new int[m], 0);
        int[][] transitions = buildTransitions();

        int[] dp = new int[validCols.size()];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            int[] nextDp = new int[validCols.size()];
            for (int j = 0; j < validCols.size(); j++)
                for (int k : transitions[j])
                    nextDp[j] = (nextDp[j] + dp[k]) % MOD;
            dp = nextDp;
        }

        int result = 0;
        for (int val : dp)
            result = (result + val) % MOD;
        return result;
    }

    private void generateValidColumns(int m, int[] col, int idx) {
        if (idx == m) {
            validCols.add(Arrays.copyOf(col, m));
            return;
        }
        for (int color = 0; color < 3; color++) {
            if (idx > 0 && col[idx - 1] == color) continue;
            col[idx] = color;
            generateValidColumns(m, col, idx + 1);
        }
    }

    private int[][] buildTransitions() {
        int size = validCols.size();
        List<Integer>[] transitions = new List[size];
        for (int i = 0; i < size; i++) {
            transitions[i] = new ArrayList<>();
            for (int j = 0; j < size; j++)
                if (isCompatible(validCols.get(i), validCols.get(j)))
                    transitions[i].add(j);
        }
        int[][] result = new int[size][];
        for (int i = 0; i < size; i++)
            result[i] = transitions[i].stream().mapToInt(x -> x).toArray();
        return result;
    }

    private boolean isCompatible(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++)
            if (a[i] == b[i]) return false;
        return true;
    }
}
