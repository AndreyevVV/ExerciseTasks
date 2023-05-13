package LeetCode.LeetCode_75_Level_2.Day_6_Tree.Easy.Balanced_Binary_Tree.Recursive;

import LeetCode.LeetCode_75_Level_2.Day_6_Tree.Easy.TreeNode;

import java.util.concurrent.atomic.AtomicBoolean;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().start());
    }

    private boolean start() {
        TreeNode seven = new TreeNode(4);
        TreeNode six = new TreeNode(4);
        TreeNode five = new TreeNode(3);
        TreeNode four = new TreeNode(3, six, seven);
        TreeNode three = new TreeNode(2);
        TreeNode two = new TreeNode(2, four, five);
        TreeNode root = new TreeNode(1, two, three);
        System.out.println(root);
        return isBalanced(root);
    }

    public boolean isBalanced(TreeNode root) {
        AtomicBoolean isBalanced = new AtomicBoolean(true);
        isHeightBalanced(root, isBalanced);

        return isBalanced.get();
    }

    public static int isHeightBalanced(TreeNode root, AtomicBoolean isBalanced) {
        if (root == null || !isBalanced.get()) {
            return 0;
        }

        int left_height = isHeightBalanced(root.left, isBalanced);
        int right_height = isHeightBalanced(root.right, isBalanced);

        if (Math.abs(left_height - right_height) > 1) {
            isBalanced.set(false);
        }

        return Math.max(left_height, right_height) + 1;
    }
}
