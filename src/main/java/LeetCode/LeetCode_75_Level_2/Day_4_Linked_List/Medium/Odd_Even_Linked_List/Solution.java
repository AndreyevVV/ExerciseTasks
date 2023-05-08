package LeetCode.LeetCode_75_Level_2.Day_4_Linked_List.Medium.Odd_Even_Linked_List;

public class Solution {

    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode pointToConnect = evenHead;

        while (oddHead.next.next != null && evenHead.next.next != null) {
            ListNode previousOddHead = oddHead;
            ListNode previousEvenHead = evenHead;

            evenHead = evenHead.next.next;
            oddHead = oddHead.next.next;

            previousOddHead.next = oddHead;
            previousEvenHead.next = evenHead;
        }

        if (evenHead.next == null) {
            oddHead.next = pointToConnect;
        } else {
            oddHead.next = evenHead.next;
            evenHead.next = null;
            oddHead.next.next = pointToConnect;
        }
        return head;
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
