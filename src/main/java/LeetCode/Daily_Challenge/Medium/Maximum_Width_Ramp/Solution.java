package LeetCode.Daily_Challenge.Medium.Maximum_Width_Ramp;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++)
            indices[i] = i;

        Arrays.sort(indices, Comparator.comparingInt(i -> nums[i]));

        int minIndex = n;
        int maxRamp = 0;

        for (int i : indices) {
            maxRamp = Math.max(maxRamp, i - minIndex);
            minIndex = Math.min(minIndex, i);
        }

        return maxRamp;
    }
}
