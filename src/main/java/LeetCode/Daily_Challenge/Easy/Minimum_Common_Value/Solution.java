package LeetCode.Daily_Challenge.Easy.Minimum_Common_Value;

public class Solution {

    public int getCommon(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 ||
                nums2 == null || nums2.length == 0) return -1;
        if (nums1[0] == nums2[0]) return nums1[0];

        int i1 = 0, i2 = 0;

        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] < nums2[i2])
                i1++;
            else if (nums1[i1] > nums2[i2])
                i2++;
            else
                return nums1[i1];
        }
        return -1;
    }
}
