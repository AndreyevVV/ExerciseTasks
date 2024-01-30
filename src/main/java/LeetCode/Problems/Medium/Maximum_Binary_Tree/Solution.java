package LeetCode.Problems.Medium.Maximum_Binary_Tree;

import java.util.Stack;

public class Solution {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        Stack<TreeNode> stack = new Stack<>();

        for (int num : nums) {
            TreeNode current = new TreeNode(num);

            while (!stack.isEmpty() && current.val > stack.peek().val)
                current.left = stack.pop();

            if (!stack.isEmpty() && current.val < stack.peek().val)
                stack.peek().right = current;

            stack.push(current);
        }

        return stack.isEmpty() ? null : stack.firstElement();
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
