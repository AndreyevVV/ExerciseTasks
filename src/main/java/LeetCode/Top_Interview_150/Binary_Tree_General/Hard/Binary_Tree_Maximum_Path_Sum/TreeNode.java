package LeetCode.Top_Interview_150.Binary_Tree_General.Hard.Binary_Tree_Maximum_Path_Sum;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

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
