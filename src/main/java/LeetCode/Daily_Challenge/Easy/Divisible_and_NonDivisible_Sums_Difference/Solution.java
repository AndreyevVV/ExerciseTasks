package LeetCode.Daily_Challenge.Easy.Divisible_and_NonDivisible_Sums_Difference;

public class Solution {

    public int differenceOfSums(int n, int m) {
        int totalSum = n * (n + 1) / 2;
        int count = n / m;
        int divisibleSum = m * count * (count + 1) / 2;

        return totalSum - 2 * divisibleSum;
    }
}
