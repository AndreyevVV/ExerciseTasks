package LeetCode.Top_Interview_150.Binary_Tree_General.Easy.Count_Complete_Tree_Nodes.Iterative_solution;

import LeetCode.Top_Interview_150.Binary_Tree_General.Easy.Count_Complete_Tree_Nodes.TreeNode;

import java.util.Stack;

public class Solution {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        Stack<TreeNode> stack = new Stack<>();
        int count = 0;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                count++;
                root = root.left;
            }

            root = stack.pop();
            root = root.right;
        }
        return count;
    }
}
