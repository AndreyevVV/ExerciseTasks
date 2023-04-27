package LeetCode.Arrays_101.In_Place_Operations.Easy.Move_Zeroes;

public class Solution {

    public void moveZeroes(int[] nums) {
        int nonZeroPointer = 0;
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroPointer++] = nums[i];
            }
        }
        for (int i = nonZeroPointer; i < length; i++) {
            nums[i] = 0;
        }
    }
}
