package LeetCode.LeetCode_75_Level_1.Day_8_Binary_Search_Tree.Medium.Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode LCA = root;

        while (LCA != null) {

            if (p.val < LCA.val && q.val < LCA.val) {
                LCA = LCA.left;
            } else if (p.val > LCA.val && q.val > LCA.val) {
                LCA = LCA.right;
            } else return LCA;
        }
        return LCA;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "{" +
                    val + " " +
                    left.val + " " +
                    right.val + " " +
                    "}";
        }
    }
}
