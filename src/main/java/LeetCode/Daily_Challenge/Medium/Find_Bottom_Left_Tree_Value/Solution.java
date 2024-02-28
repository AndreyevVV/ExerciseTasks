package LeetCode.Daily_Challenge.Medium.Find_Bottom_Left_Tree_Value;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int elementsOnLevel = queue.size();
            TreeNode node = new TreeNode();

            for (int i = 0; i < elementsOnLevel; i++) {
                node = queue.poll();
                if (node.right != null) queue.offer(node.right);
                if (node.left != null) queue.offer(node.left);
            }
            if (queue.isEmpty()) {
                return node.val;
            }
        }
        return root.val;
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