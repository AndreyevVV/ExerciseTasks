package LeetCode.LeetCode_75_Level_2.Day_9_Binary_Search_Tree.Easy.Convert_Sorted_Array_to_Binary_Search_Tree;

public class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
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
