package LeetCode.Daily_Challenge.Easy.Maximum_Area_of_Longest_Diagonal_Rectangle;

public class Solution {

    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiagonal = 0;
        int maxArea = 0;

        for (int[] rect : dimensions) {
            int len = rect[0], wid = rect[1];
            int diagonal = len * len + wid * wid;
            int area = len * wid;

            if (diagonal > maxDiagonal || (diagonal == maxDiagonal && area > maxArea)) {
                maxDiagonal = diagonal;
                maxArea = area;
            }
        }
        return maxArea;
    }
}
