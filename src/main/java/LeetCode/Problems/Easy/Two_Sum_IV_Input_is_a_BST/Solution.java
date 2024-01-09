package LeetCode.Problems.Easy.Two_Sum_IV_Input_is_a_BST;

import java.util.Stack;

public class Solution {
//    public static void main(String[] args) {
//        System.out.println(new Solution().start());
//    }
//
//    private boolean start() {
//
//        return findTarget(TreeNode root, k);
//    }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node != null) {
                int complement = k - node.val;

                if(findComplement(root, complement, node)) return true;

                stack.push(node.left);
                stack.push(node.right);
            }
        }
        return false;
    }

    private boolean findComplement(TreeNode root, int complementaryPart, TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (root.val == complementaryPart && root != node) return true;
            root = root.right;
        }
        return false;
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
