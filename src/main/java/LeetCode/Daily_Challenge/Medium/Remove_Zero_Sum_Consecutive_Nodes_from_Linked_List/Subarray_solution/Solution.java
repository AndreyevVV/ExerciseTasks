package LeetCode.Daily_Challenge.Medium.Remove_Zero_Sum_Consecutive_Nodes_from_Linked_List.Subarray_solution;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public ListNode removeZeroSumSublists(ListNode head) {
        List<Integer> values = new ArrayList<>();
        ListNode current = head;

        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        for (int i = 0; i < values.size(); i++) {
            int sum = 0;
            for (int j = i; j < values.size(); j++) {
                sum += values.get(j);
                if (sum == 0) {
                    values.subList(i, j + 1).clear();
                    i--;
                    break;
                }
            }
        }

        ListNode dummy = new ListNode(0);
        current = dummy;
        for (int value : values) {
            current.next = new ListNode(value);
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
