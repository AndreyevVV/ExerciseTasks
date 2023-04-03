package LeetCode.LeetCode_75_Level_1.Day_6_Tree.Medium.Binary_Tree_Level_Order_Traversal;

import java.util.*;

public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();

        if (root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int elemsOnLevel = queue.size();

            List<Integer> innerList = new ArrayList<>();

            for (int i = 0; i < elemsOnLevel; i++) {

                root = queue.poll();

                innerList.add(root.val);

                if (root.left != null) queue.add(root.left);
                if (root.right != null) queue.add(root.right);
            }
            list.add(innerList);
        }
        return list;
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
