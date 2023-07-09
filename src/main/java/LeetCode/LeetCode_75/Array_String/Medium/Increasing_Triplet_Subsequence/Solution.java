package LeetCode.LeetCode_75.Array_String.Medium.Increasing_Triplet_Subsequence;

public class Solution {

    public boolean increasingTriplet(int[] nums) {
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= left) left = num;
            else if (num <= right) right = num;
            else return true;
        }
        return false;
    }
}
