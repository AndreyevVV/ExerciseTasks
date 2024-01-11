package LeetCode.Daily_Challenge.Medium.Maximum_Difference_Between_Node_and_Ancestor.Recursive_solution;

public class Solution {

    public int maxAncestorDiff(TreeNode root) {
        return helper(root, root.val, root.val);
    }

    private int helper(TreeNode node, int min, int max) {
        if (node == null)
            return max - min;

        min = Math.min(min, node.val);
        max = Math.max(max, node.val);

        int leftDiff = helper(node.left, min, max);
        int rightDiff = helper(node.right, min, max);

        return Math.max(leftDiff, rightDiff);
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
