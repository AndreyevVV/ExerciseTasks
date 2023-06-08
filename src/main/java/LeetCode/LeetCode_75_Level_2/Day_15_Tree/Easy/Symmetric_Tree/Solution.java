package LeetCode.LeetCode_75_Level_2.Day_15_Tree.Easy.Symmetric_Tree;

import LeetCode.LeetCode_75_Level_2.Day_15_Tree.Easy.TreeNode;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root. right == null) return true;

        return dfs (root.left, root.right);
    }

    private boolean dfs (TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;

        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
