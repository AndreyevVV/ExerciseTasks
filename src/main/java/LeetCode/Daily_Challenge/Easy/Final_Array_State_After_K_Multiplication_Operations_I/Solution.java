package LeetCode.Daily_Challenge.Easy.Final_Array_State_After_K_Multiplication_Operations_I;

public class Solution {

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            int minIndex = 0;

            for (int j = 1; j < nums.length; j++)
                if (nums[j] < nums[minIndex])
                    minIndex = j;

            nums[minIndex] *= multiplier;
        }
        return nums;
    }
}
