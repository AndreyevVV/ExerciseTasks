package LeetCode.Problems.Easy.Binary_Tree_Preorder_Traversal.Second_Stack_solution;

import LeetCode.Problems.Easy.Binary_Tree_Preorder_Traversal.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> result = new ArrayList();
        Stack<TreeNode> treeS = new Stack();

        while (root != null || !treeS.isEmpty()) {
            result.add(root.val);

            if (root.right != null)
                treeS.push(root.right);

            root = root.left;

            if (root == null && !treeS.isEmpty())
                root = treeS.pop();
        }
        return result;
    }
}
