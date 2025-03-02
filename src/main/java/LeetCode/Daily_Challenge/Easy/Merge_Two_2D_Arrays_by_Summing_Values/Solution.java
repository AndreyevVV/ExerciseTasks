package LeetCode.Daily_Challenge.Easy.Merge_Two_2D_Arrays_by_Summing_Values;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i][0] < nums2[j][0]) {
                result.add(nums1[i]);
                i++;
            } else if (nums1[i][0] > nums2[j][0]) {
                result.add(nums2[j]);
                j++;
            } else {
                result.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            }
        }

        while (i < nums1.length)
            result.add(nums1[i++]);

        while (j < nums2.length)
            result.add(nums2[j++]);

        return result.toArray(new int[0][]);
    }
}
