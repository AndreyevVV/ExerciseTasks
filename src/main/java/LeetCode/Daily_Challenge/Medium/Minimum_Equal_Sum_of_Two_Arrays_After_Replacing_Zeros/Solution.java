package LeetCode.Daily_Challenge.Medium.Minimum_Equal_Sum_of_Two_Arrays_After_Replacing_Zeros;

public class Solution {

    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int zeros1 = 0, zeros2 = 0;

        for (int num : nums1) {
            if (num == 0) zeros1++;
            else sum1 += num;
        }

        for (int num : nums2) {
            if (num == 0) zeros2++;
            else sum2 += num;
        }

        if (zeros1 == 0 && zeros2 == 0)
            return sum1 == sum2 ? sum1 : -1;

        if (zeros1 > 0 && zeros2 == 0)
            return sum1 + zeros1 <= sum2 ? sum2 : -1;

        if (zeros2 > 0 && zeros1 == 0)
            return sum2 + zeros2 <= sum1 ? sum1 : -1;

        return Math.max(sum1 + zeros1, sum2 + zeros2);
    }
}
