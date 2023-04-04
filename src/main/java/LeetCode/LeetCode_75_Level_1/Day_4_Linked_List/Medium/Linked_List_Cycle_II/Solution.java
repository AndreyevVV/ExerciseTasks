package LeetCode.LeetCode_75_Level_1.Day_4_Linked_List.Medium.Linked_List_Cycle_II;

public class Solution {

    public ListNode detectCycle(ListNode head) {

        ListNode turtle = head;
        ListNode rabbit = head;

        while (rabbit != null && rabbit.next != null) {

            turtle = turtle.next;
            rabbit = rabbit.next.next;

            if (turtle == rabbit) {

                while (head != rabbit) {
                    rabbit = rabbit.next;
                    head = head.next;
                }
                return head;
            }
        }
        return null;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
