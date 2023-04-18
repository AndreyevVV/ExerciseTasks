package LeetCode.Arrays_101.Introduction.Easy.Max_Consecutive_Ones;

public class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {

        int maxWindowSize = 0;
        int leftWindowBorder = 0, rightWindowBorder = 0;
        int numsLength = nums.length;

        while (leftWindowBorder < numsLength) {

            while (leftWindowBorder < numsLength && nums[leftWindowBorder] != 1) leftWindowBorder++;

            rightWindowBorder = leftWindowBorder;

            while (rightWindowBorder < numsLength && nums[rightWindowBorder] == 1) rightWindowBorder++;

            maxWindowSize = Math.max(maxWindowSize, rightWindowBorder - leftWindowBorder);
            leftWindowBorder = rightWindowBorder;
        }
        return maxWindowSize;
    }
}
