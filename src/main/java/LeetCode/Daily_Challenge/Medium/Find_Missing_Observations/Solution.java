package LeetCode.Daily_Challenge.Medium.Find_Missing_Observations;

public class Solution {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int totalSum = mean * (n + rolls.length);

        int observedSum = 0;
        for (int roll : rolls)
            observedSum += roll;

        int missingSum = totalSum - observedSum;

        if (missingSum < n || missingSum > 6 * n)
            return new int[0];

        int[] missingRolls = new int[n];

        int avg = missingSum / n;
        int remainder = missingSum % n;

        for (int i = 0; i < n; i++)
            missingRolls[i] = avg + (i < remainder ? 1 : 0);

        return missingRolls;
    }
}
