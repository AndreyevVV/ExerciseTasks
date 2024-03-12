package LeetCode.Daily_Challenge.Medium.Remove_Zero_Sum_Consecutive_Nodes_from_Linked_List.PrefixSum_solution;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        Map<Integer, ListNode> prefixSumMap = new HashMap<>();
        int prefixSum = 0;
        ListNode current = dummy;

        while (current != null) {
            prefixSum += current.val;
            if (prefixSumMap.containsKey(prefixSum)) {
                ListNode temp = prefixSumMap.get(prefixSum).next;
                int sum = prefixSum + temp.val;

                while (sum != prefixSum) {
                    prefixSumMap.remove(sum);
                    temp = temp.next;
                    sum += temp.val;
                }

                prefixSumMap.get(prefixSum).next = current.next;
            } else
                prefixSumMap.put(prefixSum, current);

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
