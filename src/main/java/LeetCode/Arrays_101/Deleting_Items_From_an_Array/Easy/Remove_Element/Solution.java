package LeetCode.Arrays_101.Deleting_Items_From_an_Array.Easy.Remove_Element;

import static java.util.Arrays.sort;

public class Solution {
    public static void main(String[] args) {

        int[] nums = {...}; // Input array
        int val = ...; // Value to remove
        int[] expectedNums = {...}; // The expected answer with correct length.
        // It is sorted with no values equaling val.

        int k = new Solution().removeElement(nums, val); // Calls your implementation

        assert k == expectedNums.length;
        sort(nums, 0, k); // Sort the first k elements of nums
        for (int i = 0; i < nums.length; i++) {
            assert nums[i] == expectedNums[i];
        }
    }

    public int removeElement(int[] nums, int val) {
        int k = nums.length, length = nums.length;

        for (int i = length - 1; i >= 0; i--) {
            if (nums[i] == val) {
                k--;
                for (int j = i + 1; j <= length - 1; j++) {
                    nums[j - 1] = nums[j];
                }
            }
        }
        return k;
    }
}
