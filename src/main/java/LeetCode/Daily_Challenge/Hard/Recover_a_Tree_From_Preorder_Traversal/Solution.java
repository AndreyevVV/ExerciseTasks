package LeetCode.Daily_Challenge.Hard.Recover_a_Tree_From_Preorder_Traversal;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {


    public TreeNode recoverFromPreorder(String traversal) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        int i = 0, n = traversal.length();

        while (i < n) {
            int depth = 0;
            while (i < n && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }

            int numStart = i;

            while (i < n && Character.isDigit(traversal.charAt(i)))
                i++;

            int val = Integer.parseInt(traversal.substring(numStart, i));

            TreeNode node = new TreeNode(val);

            while (stack.size() > depth)
                stack.pop();

            if (!stack.isEmpty()) {
                if (stack.peek().left == null)
                    stack.peek().left = node;
                else
                    stack.peek().right = node;
            }

            stack.push(node);
        }

        while (stack.size() > 1)
            stack.pop();

        return stack.peek();
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
