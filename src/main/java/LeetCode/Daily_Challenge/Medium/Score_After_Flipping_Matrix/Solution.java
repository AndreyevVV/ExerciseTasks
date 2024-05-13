package LeetCode.Daily_Challenge.Medium.Score_After_Flipping_Matrix;

public class Solution {

    private void flipRow(int[][] matrix, int rowIndex) {
        for (int colIndex = 0; colIndex < matrix[0].length; colIndex++)
            matrix[rowIndex][colIndex] = 1 - matrix[rowIndex][colIndex];
    }

    private void flipCol(int[][] matrix, int colIndex) {
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++)
            matrix[rowIndex][colIndex] = 1 - matrix[rowIndex][colIndex];
    }

    private int convertRowToDecimal(int[] row) {
        int result = 0;
        for (int bit : row)
            result = result * 2 + bit;
        return result;
    }

    public int matrixScore(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        for (int rowIndex = 0; rowIndex < numRows; rowIndex++)
            if (matrix[rowIndex][0] == 0)
                flipRow(matrix, rowIndex);

        for (int colIndex = 1; colIndex < numCols; colIndex++) {
            int countOnes = 0;

            for (int rowIndex = 0; rowIndex < numRows; rowIndex++)
                if (matrix[rowIndex][colIndex] == 1)
                    countOnes++;

            if (countOnes * 2 < numRows)
                flipCol(matrix, colIndex);
        }

        int totalScore = 0;
        for (int[] row : matrix)
            totalScore += convertRowToDecimal(row);

        return totalScore;
    }
}
