package LeetCode.Problems.Easy.Binary_Tree_Preorder_Traversal.First_Stack_solution;

import LeetCode.Problems.Easy.Binary_Tree_Preorder_Traversal.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().start());
    }

    private List<Integer> start() {

        TreeNode three = new TreeNode(3);
        TreeNode second = new TreeNode(2, three, null);
        TreeNode root = new TreeNode(1, null, second);

        return preorderTraversal(root);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);

            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return list;
    }
}
