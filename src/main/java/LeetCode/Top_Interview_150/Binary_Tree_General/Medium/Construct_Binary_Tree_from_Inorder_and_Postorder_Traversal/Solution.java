package LeetCode.Top_Interview_150.Binary_Tree_General.Medium.Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

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

        return buildTree(postorderTraversal(head), inorderTraversal(head));
    }

    public int[] postorderTraversal(TreeNode head) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;

        if (head == null) return new int[]{};

        do {
            while (head != null) {
                stack.push(head);
                head = head.left;
            }

            while (head == null && !stack.isEmpty()) {
                head = stack.peek();
                if (head.right == null || head.right == prev) {
                    result.add(head.val);
                    stack.pop();
                    prev = head;
                    head = null;
                } else
                    head = head.right;
            }
        } while (!stack.isEmpty());
        return result.stream().mapToInt(Integer::intValue).toArray();
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0)
            return null;

        int postIndex = postorder.length - 1;
        return buildTreeHelper(inorder, postorder, 0, inorder.length - 1, postIndex);
    }

    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inStart, int inEnd, int postIndex) {
        if (inStart > inEnd || postIndex < 0)
            return null;

        int rootVal = postorder[postIndex];
        TreeNode root = new TreeNode(rootVal);

        int inorderIndex = inStart;
        while (inorder[inorderIndex] != rootVal)
            inorderIndex++;

        root.right = buildTreeHelper(inorder, postorder, inorderIndex + 1, inEnd, postIndex - 1);
        root.left = buildTreeHelper(inorder, postorder, inStart, inorderIndex - 1, postIndex - (inEnd - inorderIndex + 1));

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
            return "{" + val +
                    " " + left +
                    " " + right +
                    '}';
        }
    }
}
