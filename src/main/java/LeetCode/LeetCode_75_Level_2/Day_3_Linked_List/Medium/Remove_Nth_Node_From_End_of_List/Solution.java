package LeetCode.LeetCode_75_Level_2.Day_3_Linked_List.Medium.Remove_Nth_Node_From_End_of_List;

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode();
        start.next = head;

        ListNode fast = start;
        ListNode slow = start;

        for (int i = 1; i <= n; ++i)
            fast = fast.next;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return start.next;
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
            return val + " " + next;
        }
    }
}
