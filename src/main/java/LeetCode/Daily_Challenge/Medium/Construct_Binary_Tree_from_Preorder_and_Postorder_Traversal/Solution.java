package LeetCode.Daily_Challenge.Medium.Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> postIndex = new HashMap<>();

        for (int i = 0; i < postorder.length; i++)
            postIndex.put(postorder[i], i);

        return buildTree(preorder, 0, preorder.length - 1, 0, postorder.length - 1, postIndex);
    }

    private TreeNode buildTree(int[] pre, int preStart, int preEnd,
                               int postStart, int postEnd,
                               Map<Integer, Integer> postIndex) {
        if (preStart > preEnd) return null;
        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart == preEnd) return root;

        int leftRootVal = pre[preStart + 1];
        int leftSubtreeSize = postIndex.get(leftRootVal) - postStart + 1;

        root.left = buildTree(pre, preStart + 1, preStart + leftSubtreeSize,
                postStart, postStart + leftSubtreeSize - 1, postIndex);
        root.right = buildTree(pre, preStart + leftSubtreeSize + 1, preEnd,
                postStart + leftSubtreeSize, postEnd - 1, postIndex);
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
    }
}
