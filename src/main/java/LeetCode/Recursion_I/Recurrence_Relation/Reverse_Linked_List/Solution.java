package LeetCode.Recursion_I.Recurrence_Relation.Reverse_Linked_List;

public class Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode reverseHead = head.next;

        ListNode previous = reverseList(head.next);

        reverseHead.next = head;
        head.next = null;
        return previous;
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
}
