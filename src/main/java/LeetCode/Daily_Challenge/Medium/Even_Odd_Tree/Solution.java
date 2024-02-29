package LeetCode.Daily_Challenge.Medium.Even_Odd_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().start());
    }

    private boolean start() {

        TreeNode seven = new TreeNode(7);
        TreeNode two = new TreeNode(2, seven, null);
        TreeNode threeLeft = new TreeNode(3);
        TreeNode threeRight = new TreeNode(3);
        TreeNode four = new TreeNode(4, threeLeft, threeRight);
        TreeNode root = new TreeNode(5, four, two);

        return isEvenOddTree(root);
    }

    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int prevValue = ((level & 1) == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (((level & 1) == 0 && ((node.val & 1) == 0 || node.val <= prevValue))
                        || ((level & 1) == 1 && ((node.val & 1) != 0 || node.val >= prevValue)))
                    return false;

                prevValue = node.val;

                if (node.left != null)queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            level++;
        }
        return true;
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
