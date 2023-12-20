package LeetCode.Problems.Easy.Largest_Local_Values_in_a_Matrix;

public class Solution {

    public int[][] largestLocal(int[][] grid) {

        int n = grid.length - 2;
        int[][] maxLocal = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int largest = Integer.MIN_VALUE;

                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (grid[k][l] > largest) {
                            largest = grid[k][l];
                        }
                    }
                }
                maxLocal[i][j] = largest;
            }
        }
        return maxLocal;
    }
}
