package LeetCode.LeetCode_75_Level_2.Day_9_Binary_Search_Tree.Medium.Binary_Search_Tree_Iterator;

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
