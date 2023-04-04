package LeetCode.LeetCode_75_Level_1.Day_8_Binary_Search_Tree.Medium.Validate_Binary_Search_Tree;

import java.util.Stack;

public class Solution {

    public boolean isValidBST(TreeNode root) {
        TreeNode prev = null;

        if (root == null) return false;

        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {

            while(root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if(prev != null && root.val <= prev.val) {
                return false;
            }

            prev = root;
            root = root.right;
        }
        return true;
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

        @Override
        public String toString() {
            return "{" +
                    "" + val +
                    " " + left +
                    " " + right +
                    "}";
        }
    }
}
