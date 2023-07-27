package LeetCode.LeetCode_75.Linked_List.Medium.Delete_the_Middle_Node_of_a_Linked_List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().start());
    }

    private ListNode start() {

        ListNode six = new ListNode(6, null);
        ListNode five = new ListNode(2, six);
        ListNode four = new ListNode(1, five);
        ListNode three = new ListNode(7, four);
        ListNode two = new ListNode(4, three);
        ListNode one = new ListNode(3, two);
        ListNode head = new ListNode(1, one);

        return deleteMiddle(head);
    }

    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
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
            return String.format("%s %s", val, next);
        }
    }
}
