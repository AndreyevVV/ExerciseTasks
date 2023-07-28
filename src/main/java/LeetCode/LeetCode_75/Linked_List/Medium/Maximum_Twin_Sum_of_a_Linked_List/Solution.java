package LeetCode.LeetCode_75.Linked_List.Medium.Maximum_Twin_Sum_of_a_Linked_List;

import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().start());
    }

    private int start() {

        ListNode three = new ListNode(3, null);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(2, two);
        ListNode head = new ListNode(4, one);

        return pairSum(head);
    }

    public int pairSum(ListNode head) {
        if (head == null) return 0;
        if (head.next.next == null) return head.val + head.next.val;

        ListNode slow = head;
        ListNode fast = head.next;

        Stack<Integer> stack = new Stack<>();
        stack.push(slow.val);

        while (fast != null && fast.next != null) {
            slow = slow.next;
            stack.push(slow.val);
            fast = fast.next.next;
        }

        ListNode newHead = slow.next;
        int maxTwinSum = Integer.MIN_VALUE;

        while (newHead != null) {
            maxTwinSum = Math.max(maxTwinSum, stack.pop() + newHead.val);
            newHead = newHead.next;
        }
        return maxTwinSum;
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
