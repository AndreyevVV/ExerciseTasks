package LeetCode.Top_Interview_150.Binary_Tree_BFS.Medium.Binary_Tree_Level_Order_Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            int elementsOnLevel = queue.size();
            List<Integer> elementsOnLevelList = new ArrayList<>();

            for (int i = 0; i < elementsOnLevel; i++) {
                TreeNode node = queue.poll();
                elementsOnLevelList.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            list.add(elementsOnLevelList);
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
