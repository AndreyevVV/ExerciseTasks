package LeetCode.Daily_Challenge.Medium.Merge_Nodes_in_Between_Zeros;

public class Solution {

    public ListNode mergeNodes(ListNode head) {
        if(head == null) return head;
        ListNode node = head.next;
        ListNode curr = node;

        while (curr != null) {
            int sum = 0;
            while (curr.val != 0) {
                sum += curr.val;
                curr = curr.next;
            }

            node.val = sum;
            curr = curr.next;
            node.next = curr;
            node = node.next;
        }
        return head.next;
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
