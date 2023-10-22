package LeetCode.Top_Interview_150.Binary_Tree_General.Medium.Flatten_Binary_Tree_to_Linked_List;

import java.util.Stack;

public class Solution {

    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode listNode = new TreeNode();

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            listNode.right = node;
            listNode.left = null;
            listNode = listNode.right;

            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
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
