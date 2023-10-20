package LeetCode.Top_Interview_150.Binary_Tree_General.Medium.Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().start());
    }

    private TreeNode start() {

        TreeNode seven = new TreeNode(7);
        TreeNode fifteen = new TreeNode(15);
        TreeNode twenty = new TreeNode(20, fifteen, seven);
        TreeNode nine = new TreeNode(9);
        TreeNode head = new TreeNode(3, nine, twenty);

        return buildTree(preorderTraversal(head), inorderTraversal(head));
    }

    public int[] preorderTraversal(TreeNode head) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(head);
        List<Integer> list = new ArrayList<>();

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);

            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] inorderTraversal(TreeNode head) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        while (!stack.isEmpty() || head != null) {
            while (head != null) {
                stack.push(head);
                head = head.left;
            }

            head = stack.pop();
            list.add(head.val);
            head = head.right;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode currentNode = root;

        int inorderIndex = 0;

        for (int i = 1; i < preorder.length; i++) {
            if (currentNode.val != inorder[inorderIndex]) {
                currentNode.left = new TreeNode(preorder[i]);
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                inorderIndex++;
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    currentNode = stack.pop();
                    inorderIndex++;
                }
                currentNode.right = new TreeNode(preorder[i]);
                currentNode = currentNode.right;
            }
        }
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "{" +
                    "" + val +
                    " " + left +
                    " " + right +
                    '}';
        }
    }
}
