package LeetCode.LeetCode_75_Level_1.Day_4_Linked_List.Easy.Middle_of_the_Linked_List;

public class Solution {

    public ListNode middleNode(ListNode head) {

        long length = 0;
        ListNode currenNode = head;

        while (currenNode != null) {
            length++;
            currenNode = currenNode.next;
        }

        long middlePoint = length / 2 + 1;
        ListNode middleNode = null;

        while (middlePoint != 0) {
            middleNode = head;
            head = head.next;
            middlePoint--;
        }

        return middleNode;
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
            return val + " " + next;
        }
    }
}
