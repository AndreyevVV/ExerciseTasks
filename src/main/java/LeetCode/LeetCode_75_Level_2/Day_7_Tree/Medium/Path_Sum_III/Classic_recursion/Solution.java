package LeetCode.LeetCode_75_Level_2.Day_7_Tree.Medium.Path_Sum_III.Classic_recursion;

import LeetCode.LeetCode_75_Level_2.Day_7_Tree.Medium.Path_Sum_III.TreeNode;

public class Solution {

    int numberOfPaths = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        dfsSum(root, targetSum, 0);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);

        return numberOfPaths;
    }

    public void dfsSum(TreeNode root, int targetSum, long curSum) {
        if (root == null) return;

        curSum = curSum + root.val;

        if (targetSum == curSum) numberOfPaths++;

        dfsSum(root.left, targetSum, curSum);
        dfsSum(root.right, targetSum, curSum);
    }
}
