package LeetCode.Top_Interview_150.Multidimensional_DP.Medium.Triangle;

import java.util.List;

public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;

        int r = triangle.size();

        int[][] dp = new int[r][r];

        for (int i = 0; i < r; i++)
            dp[r - 1][i] = triangle.get(r - 1).get(i);

        for (int i = r - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++)
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
        }
        return dp[0][0];
    }
}
