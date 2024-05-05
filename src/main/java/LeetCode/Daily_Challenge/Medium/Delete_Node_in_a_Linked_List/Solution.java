package LeetCode.Daily_Challenge.Medium.Delete_Node_in_a_Linked_List;

public class Solution {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return String.format("%s %s", val, next);
        }
    }
}
