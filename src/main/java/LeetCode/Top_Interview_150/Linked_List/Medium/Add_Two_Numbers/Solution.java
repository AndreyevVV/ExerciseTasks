package LeetCode.Top_Interview_150.Linked_List.Medium.Add_Two_Numbers;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().start());
    }

    private ListNode start() {

        ListNode head1 = new ListNode(2);
        ListNode h1_2 = new ListNode(4);
        ListNode h1_3 = new ListNode(3);
        head1.next = h1_2;
        h1_2.next = h1_3;

        ListNode head2 = new ListNode(5);
        ListNode h2_2 = new ListNode(6);
        ListNode h2_3 = new ListNode(4);
        head2.next = h2_2;
        h2_2.next = h2_3;

        return addTwoNumbers(head1, head2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode current = dummyHead;
        int overflow = 0;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = overflow + x + y;
            overflow = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (overflow > 0) current.next = new ListNode(overflow);

        return dummyHead.next;
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
