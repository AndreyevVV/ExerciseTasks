package LeetCode.Problems.Easy.Binary_Tree_Postorder_Traversal.Iterative_stack_solution;

import LeetCode.Problems.Easy.Binary_Tree_Postorder_Traversal.TreeNode;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().start());
    }

    private List<Integer> start() {

        TreeNode three = new TreeNode(3);
        TreeNode second = new TreeNode(2, three, null);
        TreeNode root = new TreeNode(1, null, second);

        return postorderTraversal(root);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;

        do {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            while (root == null && !stack.isEmpty()) {
                root = stack.peek();
                if (root.right == null || root.right == prev) {
                    list.add(root.val);
                    stack.pop();
                    prev = root;
                    root = null;
                } else
                    root = root.right;
            }
        } while (!stack.isEmpty());
        return list;
    }
}
