package LeetCode.Top_Interview_150.Linked_List.Medium.Reverse_Linked_List_II;

public class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode end = dummy;

        for (int i = 1; i < left; i++) end = end.next;

        ListNode start = end.next;
        ListNode then = start.next;

        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = end.next;
            end.next = then;
            then = start.next;
        }
        return dummy.next;
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

        @Override
        public String toString() {
            return String.format("%s %s %s", val, next);
        }
    }
}
