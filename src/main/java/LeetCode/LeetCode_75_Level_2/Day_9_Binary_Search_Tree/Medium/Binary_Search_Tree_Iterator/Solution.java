package LeetCode.LeetCode_75_Level_2.Day_9_Binary_Search_Tree.Medium.Binary_Search_Tree_Iterator;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

class BSTIterator {
    public static void main(String[] args) {

        TreeNode twenty = new TreeNode(20);
        TreeNode nine = new TreeNode(9);
        TreeNode fifteen = new TreeNode(15, nine, twenty);
        TreeNode three = new TreeNode(3);
        TreeNode root = new TreeNode(7, three, fifteen);

        BSTIterator bSTIterator = new BSTIterator(root);

        System.out.println(
                "[" +
                        bSTIterator.next() + " " +     // return 3
                        bSTIterator.next() + " " +     // return 7
                        bSTIterator.hasNext() + " " +     // return True
                        bSTIterator.next() + " " +     // return 9
                        bSTIterator.hasNext() + " " +     // return True
                        bSTIterator.next() + " " +     // return 15
                        bSTIterator.hasNext() + " " +     // return True
                        bSTIterator.next() + " " +     // return 20
                        bSTIterator.hasNext() + " " +     // return False
                        "]"
        );
    }

    Queue<TreeNode> queue;

    public BSTIterator(TreeNode root) {
        queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        inOrderTraversal(root, stack, queue);
    }

    public int next() {
        if (hasNext()) {
            return Objects.requireNonNull(queue.poll()).val;
        } else throw new RuntimeException("Queue is empty");
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    private void inOrderTraversal(TreeNode root, Stack<TreeNode> stack, Queue<TreeNode> queue) {
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            queue.add(root);
            root = root.right;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
