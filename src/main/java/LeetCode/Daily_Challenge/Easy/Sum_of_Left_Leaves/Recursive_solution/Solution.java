package LeetCode.Daily_Challenge.Easy.Sum_of_Left_Leaves.Recursive_solution;

import LeetCode.Daily_Challenge.Easy.Sum_of_Left_Leaves.TreeNode;

import java.util.Stack;

public class Solution {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;

        int leftSum = 0;

        if (root.left != null && root.left.left == null && root.left.right == null)
            leftSum += root.left.val;

        leftSum += sumOfLeftLeaves(root.left);
        leftSum += sumOfLeftLeaves(root.right);

        return leftSum;
    }
}
