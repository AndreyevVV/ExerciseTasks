package LeetCode.Daily_Challenge.Easy.Find_Missing_and_Repeated_Values;

public class Solution {

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int N = n * n;

        long sumGrid = 0, sumSquaresGrid = 0;
        long expectedSum = (long) N * (N + 1) / 2;
        long expectedSumSquares = (long) N * (N + 1) * (2 * N + 1) / 6;

        int repeated = -1, missing = -1;
        int[] freq = new int[N + 1];

        for (int[] row : grid) {
            for (int num : row) {
                sumGrid += num;
                sumSquaresGrid += (long) num * num;
                freq[num]++;
                if (freq[num] == 2)
                    repeated = num;
            }
        }

        long diff = expectedSum - sumGrid;
        long diffSquares = expectedSumSquares - sumSquaresGrid;

        long sum = diffSquares / diff;

        missing = (int) ((diff + sum) / 2);
        return new int[]{repeated, missing};
    }
}
