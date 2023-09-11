package LeetCode.Top_Interview_150.Array_String.Medium.Remove_Duplicates_from_Sorted_Array_II;

public class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) return 2;
        int j = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[j - 2] != nums[i]) nums[j++] = nums[i];
        }
        return j;
    }
}
