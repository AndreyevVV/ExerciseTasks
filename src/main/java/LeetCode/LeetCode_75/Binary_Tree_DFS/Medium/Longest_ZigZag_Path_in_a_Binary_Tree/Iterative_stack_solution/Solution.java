package LeetCode.LeetCode_75.Binary_Tree_DFS.Medium.Longest_ZigZag_Path_in_a_Binary_Tree.Iterative_stack_solution;

import LeetCode.LeetCode_75.Binary_Tree_DFS.TreeNode;

import java.util.Stack;

public class Solution {

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;

        int maxZigZagPath = 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> leftCounts = new Stack<>();
        Stack<Integer> rightCounts = new Stack<>();

        stack.push(root);
        leftCounts.push(0);
        rightCounts.push(0);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int leftCount = leftCounts.pop();
            int rightCount = rightCounts.pop();

            int curLen = Math.max(leftCount, rightCount);
            maxZigZagPath = Math.max(maxZigZagPath, curLen);

            if (node.left != null) {
                stack.push(node.left);
                leftCounts.push(++rightCount);
                rightCounts.push(0);
            }

            if (node.right != null) {
                stack.push(node.right);
                leftCounts.push(0);
                rightCounts.push(++leftCount);
            }
        }
        return maxZigZagPath;
    }
}
