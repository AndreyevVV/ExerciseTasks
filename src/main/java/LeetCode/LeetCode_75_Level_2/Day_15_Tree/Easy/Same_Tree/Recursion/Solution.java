package LeetCode.LeetCode_75_Level_2.Day_15_Tree.Easy.Same_Tree.Recursion;

import LeetCode.LeetCode_75_Level_2.Day_15_Tree.TreeNode;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (q == null && p == null) return true;

        if (q == null || p == null || q.val != p.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
