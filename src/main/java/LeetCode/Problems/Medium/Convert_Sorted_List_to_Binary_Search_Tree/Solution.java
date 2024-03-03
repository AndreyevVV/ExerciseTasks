package LeetCode.Problems.Medium.Convert_Sorted_List_to_Binary_Search_Tree;

public class Solution {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        ListNode middle = findMiddle(head);
        TreeNode root = new TreeNode(middle.val);

        if (head == middle)
            return root;

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(middle.next);

        return root;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null)
            prev.next = null;

        return slow;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
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
