package LeetCode.Daily_Challenge.Medium.Delete_Nodes_From_Linked_List_Present_in_Array;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums)
            numSet.add(num);

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {
            if (numSet.contains(current.val))
                prev.next = current.next;
            else
                prev = current;

            current = current.next;
        }

        return dummy.next;
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
    }
}
