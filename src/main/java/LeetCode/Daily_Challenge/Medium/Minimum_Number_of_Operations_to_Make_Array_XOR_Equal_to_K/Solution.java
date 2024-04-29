package LeetCode.Daily_Challenge.Medium.Minimum_Number_of_Operations_to_Make_Array_XOR_Equal_to_K;

public class Solution {

    public int minOperations(int[] nums, int k) {
        int xor = 0;
        for (int num : nums)
            xor ^= num;

        int targetXor = xor ^ k;

        int count = 0;
        while (targetXor > 0) {
            count += targetXor & 1;
            targetXor >>= 1;
        }
        return count;
    }
}
