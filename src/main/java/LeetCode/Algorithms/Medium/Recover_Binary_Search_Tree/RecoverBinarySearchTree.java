package LeetCode.Algorithms.Medium.Recover_Binary_Search_Tree;

import java.util.Stack;

class RecoverBinarySearchTree {
    TreeNode prev;
    TreeNode first;
    TreeNode second;

    public void recoverTree(TreeNode root) {
        findSwappedNodes(root);
        first.val ^= (second.val ^= first.val);
        second.val ^= first.val;
    }

    public void findSwappedNodes(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();

        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if(prev != null && root.val < prev.val) {
                if(second == null) {
                    second = prev;
                }
                first = root;
            }
            prev = root;
            root = root.right;
        }
    }

    public static class TreeNode {
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

        @Override
        public String toString() {
            return "{" +
                    "" + val +
                    " " + left +
                    " " + right +
                    '}';
        }
    }
}

