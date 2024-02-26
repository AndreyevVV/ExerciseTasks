package LeetCode.Problems.Easy.Binary_Tree_Postorder_Traversal.Recursive_solution;

import LeetCode.Problems.Easy.Binary_Tree_Postorder_Traversal.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        traversal(root, list);

        return list;
    }

    private void traversal(TreeNode root, List<Integer> list) {
        if(root == null) return;

        traversal(root.left, list);
        traversal(root.right, list);

        list.add(root.val);
    }
}
