package LeetCode.Problems.Easy.Binary_Tree_Preorder_Traversal.Recursive_solution;

import LeetCode.Problems.Easy.Binary_Tree_Preorder_Traversal.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        traversal(root, list);

        return list;
    }

    private void traversal(TreeNode root, List<Integer> list) {
        if(root == null) return;

        list.add(root.val);

        traversal(root.left, list);
        traversal(root.right, list);
    }
}
