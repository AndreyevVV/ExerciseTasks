package LeetCode.LeetCode_75_Level_2.Day_7_Tree.Easy.Diameter_of_Binary_Tree.Recursion;

import LeetCode.LeetCode_75_Level_2.Day_7_Tree.Easy.Diameter_of_Binary_Tree.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    public int diameterOfBinaryTree(TreeNode root) {

        AtomicInteger diameter = new AtomicInteger(0);

        height(root, diameter);

        return diameter.get();
    }

    public int height(TreeNode root, AtomicInteger diameter) {

        if (root == null) {
            return 0;
        }

        int left = height(root.left, diameter);
        int right = height(root.right, diameter);

        diameter.set(Math.max(diameter.get(), left + right));

        return Math.max(left, right) + 1;
    }
}
