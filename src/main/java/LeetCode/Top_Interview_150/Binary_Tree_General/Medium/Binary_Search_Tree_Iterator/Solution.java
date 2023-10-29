package LeetCode.Top_Interview_150.Binary_Tree_General.Medium.Binary_Search_Tree_Iterator;

import java.util.Stack;

public class Solution {

    class BSTIterator {
        private TreeNode current;
        private Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            current = root;
            stack = new Stack<>();
        }

        public int next() {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            int val = current.val;
            current = current.right;
            return val;
        }

        public boolean hasNext() {
            return current != null || !stack.isEmpty();
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

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
