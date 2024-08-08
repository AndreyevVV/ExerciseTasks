package LeetCode.Daily_Challenge.Medium.Spiral_Matrix_III;

public class Solution {

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        int stepCount = 0;
        int direction = 0;
        int steps = 1;

        int r = rStart;
        int c = cStart;

        result[stepCount++] = new int[]{r, c};

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (stepCount < rows * cols) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < steps; j++) {
                    r += directions[direction][0];
                    c += directions[direction][1];

                    if (r >= 0 && r < rows && c >= 0 && c < cols)
                        result[stepCount++] = new int[]{r, c};
                }
                direction = (direction + 1) % 4;
            }
            steps++;
        }

        return result;
    }
}
