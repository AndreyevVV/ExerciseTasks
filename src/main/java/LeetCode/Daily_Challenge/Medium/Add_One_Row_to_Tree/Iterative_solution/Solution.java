package LeetCode.Daily_Challenge.Medium.Add_One_Row_to_Tree.Iterative_solution;

import LeetCode.Daily_Challenge.Medium.Add_One_Row_to_Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int elementsOnLevel = queue.size();
            level++;

            for (int i = 0; i < elementsOnLevel; i++) {
                TreeNode node = queue.poll();
                if (level == depth - 1) {
                    node.left = new TreeNode(val, node.left, null);
                    node.right = new TreeNode(val, null, node.right);
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return root;
    }
}
