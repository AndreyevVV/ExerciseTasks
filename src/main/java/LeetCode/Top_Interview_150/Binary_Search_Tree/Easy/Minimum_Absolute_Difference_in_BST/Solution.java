package LeetCode.Top_Interview_150.Binary_Search_Tree.Easy.Minimum_Absolute_Difference_in_BST;

import java.util.Stack;

public class Solution {

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return -1;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        int mad = Integer.MAX_VALUE;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (prev != null)
                mad = Math.min(mad, Math.abs(root.val - prev.val));

            prev = root;
            root = root.right;
        }
        return mad;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
