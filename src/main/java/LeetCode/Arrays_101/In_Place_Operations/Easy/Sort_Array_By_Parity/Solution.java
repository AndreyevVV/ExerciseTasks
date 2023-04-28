package LeetCode.Arrays_101.In_Place_Operations.Easy.Sort_Array_By_Parity;

public class Solution {

    public int[] sortArrayByParity(int[] nums) {
        int length = nums.length;
        int evenPointer = length - 1;
        int swapCount = 0;

        for (int i = 0; i < length - swapCount; i++) {
            if (nums[i] % 2 != 0) {
                while (nums[evenPointer] % 2 != 0 && evenPointer > 0 && evenPointer > i) evenPointer--;
                if (nums[evenPointer] % 2 == 0) {
                    nums[evenPointer] ^= (nums[i] ^= nums[evenPointer]);
                    nums[i] ^= nums[evenPointer];
                    swapCount++;
                }
            }
        }
        return nums;
    }
}
