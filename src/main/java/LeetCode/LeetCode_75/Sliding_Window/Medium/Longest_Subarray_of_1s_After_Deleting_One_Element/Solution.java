package LeetCode.LeetCode_75.Sliding_Window.Medium.Longest_Subarray_of_1s_After_Deleting_One_Element;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().longestSubarray(new int[]{1, 1, 1, 0, 1, 1, 1, 0, 1}));
    }

    public int longestSubarray(int[] nums) {
        if (nums.length == 0) return 0;
        int left = 0;
        int right = 0;
        int zeroIdx = -1;

        int result = 0;
        while (right != nums.length) {
            if (nums[right] == 0) {
                left = zeroIdx + 1;
                zeroIdx = right;
            }
            result = Math.max(result, right - left);
            right++;
        }
        return result;
    }
}
