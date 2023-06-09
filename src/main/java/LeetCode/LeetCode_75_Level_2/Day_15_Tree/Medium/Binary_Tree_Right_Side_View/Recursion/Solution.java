package LeetCode.LeetCode_75_Level_2.Day_15_Tree.Medium.Binary_Tree_Right_Side_View.Recursion;

import LeetCode.LeetCode_75_Level_2.Day_15_Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        rightSideView(root, list, 0);
        return list;
    }

    public void rightSideView(TreeNode root, List<Integer> list, int level) {
        if (root == null) return;

        if (list.size() == level) list.add(root.val);
        rightSideView(root.right, list, level + 1);
        rightSideView(root.left, list, level + 1);
    }
}