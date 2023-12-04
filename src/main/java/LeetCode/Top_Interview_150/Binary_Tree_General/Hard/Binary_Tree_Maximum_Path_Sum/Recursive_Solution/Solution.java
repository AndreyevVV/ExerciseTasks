package LeetCode.Top_Interview_150.Binary_Tree_General.Hard.Binary_Tree_Maximum_Path_Sum.Recursive_Solution;

import LeetCode.Top_Interview_150.Binary_Tree_General.Hard.Binary_Tree_Maximum_Path_Sum.TreeNode;

public class Solution {

    private int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxPathSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null)
            return 0;

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        int currentPathSum = node.val + leftGain + rightGain;

        maxPathSum = Math.max(maxPathSum, currentPathSum);

        return node.val + Math.max(leftGain, rightGain);
    }
}
