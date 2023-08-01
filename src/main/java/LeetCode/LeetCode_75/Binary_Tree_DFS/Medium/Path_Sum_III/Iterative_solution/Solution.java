package LeetCode.LeetCode_75.Binary_Tree_DFS.Medium.Path_Sum_III.Iterative_solution;

import LeetCode.LeetCode_75.Binary_Tree_DFS.TreeNode;

import java.util.Stack;

public class Solution {
    int numberOfPaths = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            dfsSum(node, targetSum);

            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return numberOfPaths;
    }

    public void dfsSum(TreeNode root, int targetSum) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Long> sumStack = new Stack<>();

        stack.push(root);
        sumStack.push(0L);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            long currentSum = sumStack.pop();
            currentSum += node.val;

            if (currentSum == targetSum) numberOfPaths++;

            if (node.left != null) {
                stack.push(node.left);
                sumStack.push(currentSum);
            }
            if (node.right != null) {
                stack.push(node.right);
                sumStack.push(currentSum);
            }
        }
    }
}
