package LeetCode.Daily_Challenge.Medium.Find_Elements_in_a_Contaminated_Binary_Tree;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    class FindElements {

        private Set<Integer> values;

        public FindElements(TreeNode root) {
            values = new HashSet<>();
            recoverTree(root, 0);
        }

        private void recoverTree(TreeNode node, int val) {
            if (node == null) return;
            node.val = val;
            values.add(val);
            recoverTree(node.left, 2 * val + 1);
            recoverTree(node.right, 2 * val + 2);
        }

        public boolean find(int target) {
            return values.contains(target);
        }
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
    }
}
