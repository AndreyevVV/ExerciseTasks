package LeetCode.Daily_Challenge.Easy.Sum_of_Left_Leaves.Recursive_object_solution;

import LeetCode.Daily_Challenge.Easy.Sum_of_Left_Leaves.TreeNode;

public class Solution {

    public int left = 0;

    public int sumOfLeftLeaves(TreeNode root) {

        class Traverse {
            Traverse(TreeNode root) {
                TreeNode temp = root;
                if (temp.left != null) {
                    if (temp.left.left == null && temp.left.right == null) left += temp.left.val;
                    new Traverse(temp.left);
                }
                if (temp.right != null)
                    new Traverse(temp.right);
            }
        }
        new Traverse(root);
        return left;
    }
}
