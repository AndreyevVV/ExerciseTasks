package LeetCode.Daily_Challenge.Easy.Check_if_Array_Is_Sorted_and_Rotated;

public class Solution {

    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
                if (count > 1) return false;
            }
        }

        return true;
    }
}
