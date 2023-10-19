package LeetCode.Top_Interview_150.Binary_Tree_General.Easy.Count_Complete_Tree_Nodes.Recursive_solution;

import LeetCode.Top_Interview_150.Binary_Tree_General.Easy.Count_Complete_Tree_Nodes.TreeNode;

public class Solution {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
