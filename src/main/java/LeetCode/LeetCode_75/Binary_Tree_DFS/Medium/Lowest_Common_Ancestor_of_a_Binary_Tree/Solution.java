package LeetCode.LeetCode_75.Binary_Tree_DFS.Medium.Lowest_Common_Ancestor_of_a_Binary_Tree;

import LeetCode.LeetCode_75.Binary_Tree_DFS.TreeNode;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().start());
    }

    private TreeNode start() {

        TreeNode eight = new TreeNode(8);
        TreeNode zero = new TreeNode(0);
        TreeNode one = new TreeNode(1, zero, eight);
        TreeNode four = new TreeNode(4);
        TreeNode seven = new TreeNode(7);
        TreeNode two = new TreeNode(2, seven, four);
        TreeNode six = new TreeNode(6);
        TreeNode five = new TreeNode(5, six, two);
        TreeNode root = new TreeNode(3, five, one);

        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);

        return lowestCommonAncestor(root, p, q);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) throw new IllegalArgumentException("Arguments can't be null");

        Stack<TreeNode> stack = new Stack<>();
        TreeNode nodeToFind = null;
        TreeNode lca;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (root.val == p.val) {
                nodeToFind = q;
                stack.push(root);
                break;
            } else if (root.val == q.val) {
                nodeToFind = p;
                stack.push(root);
                break;
            }
            root = root.right;
        }

        if (nodeToFind != null) {
            while (!stack.isEmpty()) {
                Stack<TreeNode> substack = new Stack<>();
                TreeNode subroot = stack.pop();
                lca = subroot;

                while (!substack.isEmpty() || subroot != null) {
                    while (subroot != null) {
                        substack.push(subroot);
                        subroot = subroot.left;
                    }

                    subroot = substack.pop();
                    if (subroot.val == nodeToFind.val) return lca;
                    subroot = subroot.right;
                }
            }
        }
        return new TreeNode(-1);
    }
}
