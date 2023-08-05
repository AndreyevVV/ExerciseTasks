package LeetCode.LeetCode_75.Binary_Search_Tree.Medium.Delete_Node_in_a_BST;

import LeetCode.LeetCode_75.Binary_Search_Tree.TreeNode;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().start());
    }

    private TreeNode start() {

        TreeNode seven = new TreeNode(7);
        TreeNode four = new TreeNode(4);
        TreeNode two = new TreeNode(2);
        TreeNode six = new TreeNode(6, null, seven);
        TreeNode three = new TreeNode(3, two, four);
        TreeNode root = new TreeNode(5, three, six);

        int key = 3;

        return deleteNode(root, key);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            TreeNode minValueNode = findMinValueNode(root.right);
            root.val = minValueNode.val;
            root.right = deleteNode(root.right, minValueNode.val);
        }
        return root;
    }

    private TreeNode findMinValueNode(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
