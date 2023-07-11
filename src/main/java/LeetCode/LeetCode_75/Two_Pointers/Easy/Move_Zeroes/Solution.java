package LeetCode.LeetCode_75.Two_Pointers.Easy.Move_Zeroes;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] inputArray = {1, 0};
        new Solution().moveZeroes(inputArray);
        System.out.println(Arrays.toString(inputArray));
    }

    public void moveZeroes(int[] nums) {
//        if (nums.length <= 1) return;
        int nonZeroPointer = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                int temp = nums[nonZeroPointer];
                nums[nonZeroPointer++] = nums[fast];
                nums[fast] = temp;
            }
            fast++;
        }
    }
}
