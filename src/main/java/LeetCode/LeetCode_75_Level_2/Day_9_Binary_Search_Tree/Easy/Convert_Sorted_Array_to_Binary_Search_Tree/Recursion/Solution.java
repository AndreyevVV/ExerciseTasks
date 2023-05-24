package LeetCode.LeetCode_75_Level_2.Day_9_Binary_Search_Tree.Easy.Convert_Sorted_Array_to_Binary_Search_Tree.Recursion;

import LeetCode.LeetCode_75_Level_2.Day_9_Binary_Search_Tree.Easy.Convert_Sorted_Array_to_Binary_Search_Tree.TreeNode;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().sortedArrayToBST(new int[] {-10,-3}));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return bsMid(nums, 0, nums.length - 1);
    }
    private TreeNode bsMid (int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = bsMid(nums, left, mid - 1);
        root.right = bsMid(nums, mid + 1, right);

        return root;
    }
}
