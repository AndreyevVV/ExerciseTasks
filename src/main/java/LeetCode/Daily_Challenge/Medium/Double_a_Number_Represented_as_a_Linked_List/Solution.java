package LeetCode.Daily_Challenge.Medium.Double_a_Number_Represented_as_a_Linked_List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().start());
    }

    private ListNode start() {

        ListNode node3 = new ListNode(0);
        ListNode node2 = new ListNode(0, node3);
        ListNode head = new ListNode(5, node2);

        return doubleIt(head);
    }

    public ListNode doubleIt(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            int numberX2 = curr.val * 2;

            if (numberX2 < 10)
                curr.val = numberX2;
            else if (prev != null) {
                curr.val = numberX2 % 10;
                prev.val = prev.val + 1;
            }
            else {
                head = new ListNode(1, curr);
                curr.val = numberX2 % 10;
            }

            prev = curr;
            curr = curr.next;
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
            return String.format("%s %S", val, next);
        }
    }
}
