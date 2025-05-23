package LeetCode.Daily_Challenge.Medium.Count_the_Hidden_Sequences;

public class Solution {

    public int numberOfArrays(int[] differences, int lower, int upper) {
        long minPrefix = 0, maxPrefix = 0, prefixSum = 0;

        for (int diff : differences) {
            prefixSum += diff;
            minPrefix = Math.min(minPrefix, prefixSum);
            maxPrefix = Math.max(maxPrefix, prefixSum);
        }

        long minStart = lower - minPrefix;
        long maxStart = upper - maxPrefix;

        if (minStart > maxStart)
            return 0;

        return (int) (maxStart - minStart + 1);
    }
}
