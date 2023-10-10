package LeetCode.Top_Interview_150.Linked_List.Easy.Linked_List_Cycle;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().start());
    }

    private boolean start() {

        ListNode root = new ListNode(3);
        ListNode zero = new ListNode(2);
        ListNode one = new ListNode(0);
        ListNode two = new ListNode(-4);

        root.next = zero;
        zero.next = one;
        one.next = two;
        two.next = zero;

        return hasCycle(root);
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return String.format("%s %s", val, next);
        }
    }
}
