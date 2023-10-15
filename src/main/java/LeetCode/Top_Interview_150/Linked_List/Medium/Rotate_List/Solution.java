package LeetCode.Top_Interview_150.Linked_List.Medium.Rotate_List;

public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;

        int length = 1;
        ListNode current = head;

        while (current.next != null) {
            current = current.next;
            length++;
        }

        k = k % length;

        if (k == 0) return head;

        current.next = head;
        int distanceToNewHead = length - k - 1;
        current = head;

        for (int i = 0; i < distanceToNewHead; i++)
            current = current.next;

        ListNode newHead = current.next;
        current.next = null;

        return newHead;
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
            return String.format("%s %s", val, next);
        }
    }
}
