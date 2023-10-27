package LeetCode.Top_Interview_150.Binary_Tree_BFS.Medium.Binary_Tree_Zigzag_Level_Order_Traversal;

import java.util.*;

public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> list = new ArrayList<>();
        boolean changeDirection = false;

        while (!queue.isEmpty()) {
            int elementsOnLevel = queue.size();
            List<Integer> elementsOnLevelList = new ArrayList<>();

            for (int i = 0; i < elementsOnLevel; i++) {
                TreeNode node = queue.poll();
                elementsOnLevelList.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            if (changeDirection) Collections.reverse(elementsOnLevelList);

            list.add(elementsOnLevelList);
            changeDirection = !changeDirection;
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
    }
}
