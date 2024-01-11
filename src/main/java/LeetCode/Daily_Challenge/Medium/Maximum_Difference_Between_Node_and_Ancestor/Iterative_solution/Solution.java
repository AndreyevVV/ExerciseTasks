package LeetCode.Daily_Challenge.Medium.Maximum_Difference_Between_Node_and_Ancestor.Iterative_solution;

import java.util.Stack;

public class Solution {

    public int maxAncestorDiff(TreeNode root) {
        if (root == null)
            return 0;

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();

        nodeStack.push(root);
        minStack.push(root.val);
        maxStack.push(root.val);

        int maxDiff = 0;

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int min = minStack.pop();
            int max = maxStack.pop();

            maxDiff = Math.max(maxDiff, max - min);

            if (node.left != null) {
                nodeStack.push(node.left);
                minStack.push(Math.min(min, node.left.val));
                maxStack.push(Math.max(max, node.left.val));
            }

            if (node.right != null) {
                nodeStack.push(node.right);
                minStack.push(Math.min(min, node.right.val));
                maxStack.push(Math.max(max, node.right.val));
            }
        }
        return maxDiff;
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

        TreeNode(int val, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
