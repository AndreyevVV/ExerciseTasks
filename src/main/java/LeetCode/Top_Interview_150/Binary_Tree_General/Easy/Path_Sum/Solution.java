package LeetCode.Top_Interview_150.Binary_Tree_General.Easy.Path_Sum;

import java.util.Stack;

public class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> pathSumStack = new Stack<>();

        stack.push(root);
        pathSumStack.push(root.val);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int pathSum = pathSumStack.pop();

            if (node.left == null && node.right == null && pathSum == targetSum) {
                return true;
            }

            if (node.left != null) {
                stack.push(node.left);
                pathSumStack.push(pathSum + node.left.val);
            }

            if (node.right != null) {
                stack.push(node.right);
                pathSumStack.push(pathSum + node.right.val);
            }
        }
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
