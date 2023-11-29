package LeetCode.Top_Interview_150.Array_String.Hard.Trapping_Rain_Water;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public static int trap(int[] height) {
        int n = height.length;

        if (n == 0)
            return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++)
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);

        System.out.println(Arrays.toString(leftMax));

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--)
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);

        System.out.println(Arrays.toString(rightMax));

        int trappedWater = 0;

        for (int i = 0; i < n; i++)
            trappedWater += Math.min(leftMax[i], rightMax[i]) - height[i];

        return trappedWater;
    }
}
