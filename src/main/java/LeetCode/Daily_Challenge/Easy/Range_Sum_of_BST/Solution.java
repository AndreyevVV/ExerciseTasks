package LeetCode.Daily_Challenge.Easy.Range_Sum_of_BST;

import java.util.Stack;

public class Solution {

    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            if (current != null) {
                if (current.val >= low && current.val <= high)
                    sum += current.val;

                if (current.val > low)
                    stack.push(current.left);

                if (current.val < high)
                    stack.push(current.right);
            }
        }
        return sum;
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
