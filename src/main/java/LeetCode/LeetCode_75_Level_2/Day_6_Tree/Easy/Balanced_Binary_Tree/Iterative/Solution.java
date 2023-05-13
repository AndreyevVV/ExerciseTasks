package LeetCode.LeetCode_75_Level_2.Day_6_Tree.Easy.Balanced_Binary_Tree.Iterative;

import LeetCode.LeetCode_75_Level_2.Day_6_Tree.Easy.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Map<TreeNode, Integer> heights = new HashMap<>();
        heights.put(null, 0);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            TreeNode right = node.right;

            if ((left == null || heights.containsKey(left)) && (right == null || heights.containsKey(right))) {
                int left_height = heights.get(left);
                int right_height = heights.get(right);
                if (Math.abs(left_height - right_height) > 1) {
                    return false;
                }
                heights.put(node, Math.max(left_height, right_height) + 1);
            } else {
                stack.push(node);
                if (right != null && !heights.containsKey(right)) {
                    stack.push(right);
                }
                if (left != null && !heights.containsKey(left)) {
                    stack.push(left);
                }
            }
        }
        return true;
    }
}
