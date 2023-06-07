package LeetCode.LeetCode_75_Level_2.Day_15_Tree.Easy.Same_Tree.Iterative_solution;

import LeetCode.LeetCode_75_Level_2.Day_15_Tree.Easy.TreeNode;

import java.util.Stack;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(p);
        stack.push(q);

        while (!stack.isEmpty()) {
            TreeNode rootQ = stack.pop();
            TreeNode rootP = stack.pop();

            if (rootQ == null && rootP == null) return true;
            else if (rootQ == null || rootP == null) return false;
            else {
                if (rootQ.val == rootP.val) {
                    stack.push(rootQ.left);
                    stack.push(rootP.left);
                    stack.push(rootQ.right);
                    stack.push(rootP.right);
                } else return false;
            }
        }
        return true;
    }
}
