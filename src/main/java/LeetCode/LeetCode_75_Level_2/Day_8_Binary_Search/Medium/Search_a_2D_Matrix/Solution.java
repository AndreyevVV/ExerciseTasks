package LeetCode.LeetCode_75_Level_2.Day_8_Binary_Search.Medium.Search_a_2D_Matrix;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().searchMatrix(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int m = matrix.length, n = matrix[0].length, i = 0, j = n - 1;

        while (i < m & j >= 0) {
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] > target) j--;
            else i++;
        }
        return false;
    }
}
