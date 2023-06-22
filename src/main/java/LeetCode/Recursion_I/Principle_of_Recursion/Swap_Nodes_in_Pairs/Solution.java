package LeetCode.Recursion_I.Principle_of_Recursion.Swap_Nodes_in_Pairs;

public class Solution {

    public ListNode swapPairs(ListNode head) {
        if ((head == null) || (head.next == null)) return head;

        ListNode temp = head.next;
        head.next = swapPairs(head.next.next);
        temp.next = head;
        return temp;
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
            return "{" +
                    "" + val +
                    " " + next +
                    '}';
        }
    }
}
