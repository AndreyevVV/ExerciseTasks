package LeetCode.Daily_Challenge.Medium.Remove_Nodes_From_Linked_List;

public class Solution {

    public ListNode removeNodes(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode tempPrev = dummyHead;
        curr = prev;

        while (curr != null) {
            if (curr.val >= tempPrev.val) {
                tempPrev.next = curr;
                tempPrev = curr;
                curr = curr.next;
            } else {
                curr = curr.next;
            }
        }

        tempPrev.next = null;

        ListNode newPrev = null;
        ListNode newCurr = dummyHead.next;

        while (newCurr != null) {
            ListNode next = newCurr.next;
            newCurr.next = newPrev;
            newPrev = newCurr;
            newCurr = next;
        }

        return newPrev;
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
