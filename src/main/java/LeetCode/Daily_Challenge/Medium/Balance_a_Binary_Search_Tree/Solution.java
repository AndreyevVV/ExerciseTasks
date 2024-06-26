package LeetCode.Daily_Challenge.Medium.Balance_a_Binary_Search_Tree;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedList = new ArrayList<>();
        inorderTraversal(root, sortedList);
        return sortedListToBST(sortedList, 0, sortedList.size() - 1);
    }

    private void inorderTraversal(TreeNode node, List<Integer> sortedList) {
        if (node == null) return;
        inorderTraversal(node.left, sortedList);
        sortedList.add(node.val);
        inorderTraversal(node.right, sortedList);
    }

    private TreeNode sortedListToBST(List<Integer> sortedList, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(sortedList.get(mid));
        node.left = sortedListToBST(sortedList, start, mid - 1);
        node.right = sortedListToBST(sortedList, mid + 1, end);
        return node;
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
