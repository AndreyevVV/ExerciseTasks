package LeetCode.Top_Interview_150.Linked_List.Medium.Remove_Duplicates_from_Sorted_List_II;

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null) {
            boolean hasDuplicate = false;

            while (head.next != null && head.val == head.next.val) {
                head = head.next;
                hasDuplicate = true;
            }

            if (hasDuplicate)
                prev.next = head.next;
            else
                prev = prev.next;

            head = head.next;
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
    }
}
