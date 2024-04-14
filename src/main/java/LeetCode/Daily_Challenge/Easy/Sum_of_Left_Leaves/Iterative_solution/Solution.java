package LeetCode.Daily_Challenge.Easy.Sum_of_Left_Leaves.Iterative_solution;

import LeetCode.Daily_Challenge.Easy.Sum_of_Left_Leaves.TreeNode;

import java.util.Stack;

public class Solution {

    public int sumOfLeftLeaves(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int leftSum = 0;

        while (!stack.isEmpty() || root != null) {
            TreeNode prev = new TreeNode();
            while (root != null) {
                stack.push(root);
                if (root.left != null) prev = root;
                root = root.left;
            }

            root = stack.pop();
            if (root.left == null && root.right == null && prev.left == root) leftSum += root.val;
            root = root.right;
        }
        return leftSum;
    }
}
