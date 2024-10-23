package LeetCode.Daily_Challenge.Medium.Cousins_in_Binary_Tree_II;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        root.val = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int levelSum = 0;
            List<TreeNode> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node);

                if (node.left != null) {
                    queue.offer(node.left);
                    levelSum += node.left.val;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    levelSum += node.right.val;
                }
            }

            for (TreeNode node : currentLevel) {
                int siblingSum = 0;

                if (node.left != null)
                    siblingSum += node.left.val;
                if (node.right != null)
                    siblingSum += node.right.val;

                if (node.left != null)
                    node.left.val = levelSum - siblingSum;
                if (node.right != null)
                    node.right.val = levelSum - siblingSum;
            }
        }

        return root;
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
