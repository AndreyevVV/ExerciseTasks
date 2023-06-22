package LeetCode.Recursion_I.Principle_of_Recursion.Swap_Nodes_in_Pairs;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().start());
    }

    private ListNode start() {

        ListNode four = new ListNode(4);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode head = new ListNode(1, two);
        return swapPairs(head);
    }

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
