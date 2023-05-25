package LeetCode.LeetCode_75_Level_2.Day_9_Binary_Search_Tree.Medium.Kth_Smallest_Element_in_a_BST;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().start());
    }

    private int start() {

        TreeNode one = new TreeNode(1);
        TreeNode four = new TreeNode(4);
        TreeNode two = new TreeNode(2, one, null);
        TreeNode six = new TreeNode(6);
        TreeNode three = new TreeNode(3, two, four);
        TreeNode root = new TreeNode(5, three, six);

        return kthSmallest(root, 3);
    }

    public int kthSmallest(TreeNode root, int k) {
        return findKthMin(root, k, new int[]{0}, new int[]{0});
    }

    private int findKthMin(TreeNode root, int k, int[] count, int[] kthMin) {
        if (root == null) return -1;

        int leftResult = findKthMin(root.left, k, count, kthMin);
        if (leftResult != -1) return leftResult;

        count[0]++;
        if (count[0] == k) {
            kthMin[0] = root.val;
            return kthMin[0];
        }

        return findKthMin(root.right, k, count, kthMin);
    }
}
