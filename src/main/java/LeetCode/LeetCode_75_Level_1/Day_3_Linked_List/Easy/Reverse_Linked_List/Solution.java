package LeetCode.LeetCode_75_Level_1.Day_3_Linked_List.Easy.Reverse_Linked_List;

public class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode previous = null;
        ListNode currentNode = head;
        ListNode nexToReplace;

        while (currentNode != null) {
            nexToReplace = currentNode.next;
            currentNode.next = previous;
            previous = currentNode;
            currentNode = nexToReplace;
        }
        return previous;
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
