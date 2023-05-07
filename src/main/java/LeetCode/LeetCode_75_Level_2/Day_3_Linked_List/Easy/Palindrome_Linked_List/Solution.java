package LeetCode.LeetCode_75_Level_2.Day_3_Linked_List.Easy.Palindrome_Linked_List;

public class Solution {

    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode middleNode = slow;

        ListNode fromMiddleToEnd = head;
        ListNode fromMiddleTostart = middleNode.next;

        fromMiddleTostart = reverseList(fromMiddleTostart);

        while (fromMiddleToEnd != null && fromMiddleTostart != null) {
            if (fromMiddleToEnd.val != fromMiddleTostart.val) {
                return false;
            }

            fromMiddleToEnd = fromMiddleToEnd.next;
            fromMiddleTostart = fromMiddleTostart.next;
        }
        return true;
    }

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
