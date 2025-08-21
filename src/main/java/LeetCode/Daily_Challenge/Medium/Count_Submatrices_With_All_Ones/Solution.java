package LeetCode.Daily_Challenge.Medium.Count_Submatrices_With_All_Ones;

public class Solution {
    
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] height = new int[m][n];
        int res = 0;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (mat[i][j] == 0)
                    height[i][j] = 0;
                else
                    height[i][j] = (i == 0 ? 1 : height[i - 1][j] + 1);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (height[i][j] > 0) {
                    int minH = height[i][j];
                    for (int k = j; k >= 0; k--) {
                        if (height[i][k] == 0) break;
                        minH = Math.min(minH, height[i][k]);
                        res += minH;
                    }
                }
            }
        }

        return res;
    }
}
