package LeetCode.LeetCode_75_Level_2.Day_6_Tree.Easy.Invert_Binary_Tree;

import LeetCode.LeetCode_75_Level_2.Day_6_Tree.Easy.TreeNode;
import com.sun.source.tree.Tree;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().start());
    }

    private TreeNode start() {

        TreeNode nine = new TreeNode(9);
        TreeNode six = new TreeNode(6);
        TreeNode three = new TreeNode(3);
        TreeNode one = new TreeNode(1);
        TreeNode seven = new TreeNode(7, six, nine);
        TreeNode two = new TreeNode(2, one, three);
        TreeNode root = new TreeNode(4,two, seven);
        System.out.println(root);
        return invertTree(root);
    }

    public TreeNode invertTree(TreeNode root) {

        if (root == null) return root;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }
}
