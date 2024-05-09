package LeetCode.Daily_Challenge.Medium.Maximize_Happiness_of_Selected_Children;

import java.util.Arrays;

public class Solution {

    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long sum = 0;
        int n = happiness.length, j = 0;

        for (int i = n - 1; i >= n - k; i--) {
            happiness[i] = Math.max(happiness[i] - j++, 0);
            sum += happiness[i];
        }

        return sum;
    }
}
