package LeetCode.LeetCode_75.Array_String.Medium.Product_of_Array_Except_Self;

public class Solution {

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;

        int[] prefix = new int[length];
        prefix[0] = 1;

        int[] postfix = new int[length];
        postfix[length - 1] = 1;

        for (int i = 1; i < length; i++) {
            prefix[i] = nums[i - 1] * prefix[i - 1];
        }

        for (int i = length - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < length; i++) {
            prefix[i] = prefix[i] * postfix[i];
        }
        return prefix;
    }
}
