package LeetCode.Daily_Challenge.Easy.Evaluate_Boolean_Binary_Tree;

public class Solution {

    public boolean evaluateTree(TreeNode root) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null)
            return root.val == 1;

        boolean leftEval = evaluateTree(root.left);
        boolean rightEval = evaluateTree(root.right);

        if (root.val == 2)
            return leftEval || rightEval;
        else if (root.val == 3)
            return leftEval && rightEval;

        return false;
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
