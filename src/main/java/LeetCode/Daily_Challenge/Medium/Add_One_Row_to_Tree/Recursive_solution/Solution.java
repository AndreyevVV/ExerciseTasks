package LeetCode.Daily_Challenge.Medium.Add_One_Row_to_Tree.Recursive_solution;

import LeetCode.Daily_Challenge.Medium.Add_One_Row_to_Tree.TreeNode;

public class Solution {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return dfs(root, val, depth, 1);
    }

    public TreeNode dfs(TreeNode root, int val, int depth, int currdepth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        if (root == null)
            return root;

        if (currdepth == depth - 1) {
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
            return root;
        }

        dfs(root.left, val, depth, currdepth + 1);
        dfs(root.right, val, depth, currdepth + 1);

        return root;
    }
}
