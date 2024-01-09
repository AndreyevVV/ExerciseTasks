package LeetCode.LeetCode_75.Binary_Tree_DFS.Easy.LeafSimilar_Trees.Iterative_stack_solution;

import LeetCode.LeetCode_75.Binary_Tree_DFS.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().start());
    }

    private boolean start() {
        ///////////////////////////////////
        TreeNode eight = new TreeNode(8);
        TreeNode nine = new TreeNode(9);
        TreeNode one = new TreeNode(1, nine, eight);
        TreeNode four = new TreeNode(4);
        TreeNode seven = new TreeNode(7);
        TreeNode two = new TreeNode(2, seven, four);
        TreeNode six = new TreeNode(6);
        TreeNode five = new TreeNode(5, six, two);
        TreeNode root1 = new TreeNode(3, five, one);
        ///////////////////////////////////
        TreeNode eight2 = new TreeNode(8);
        TreeNode nine2 = new TreeNode(9);
        TreeNode two2 = new TreeNode(2, nine2, eight2);
        TreeNode four2 = new TreeNode(4);
        TreeNode one2 = new TreeNode(1, four2, two2);
        TreeNode seven2 = new TreeNode(7);
        TreeNode six2 = new TreeNode(6);
        TreeNode five2 = new TreeNode(5, six2, seven2);
        TreeNode root2 = new TreeNode(3, five2, one2);
        ///////////////////////////////////

        return leafSimilar(root1, root2);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == root2) return true;
        else if (root1 == null && root2 != null) return false;
        else if (root1 != null && root2 == null) return false;

        return findLeafs(root1).equals(findLeafs(root2));
    }

    private List<Integer> findLeafs(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> leafs = new ArrayList<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.left == null && root.right == null) leafs.add(root.val);
            root = root.right;
        }
        return leafs;
    }
}
