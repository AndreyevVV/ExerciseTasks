package LeetCode.Daily_Challenge.Medium.Split_Linked_List_in_Parts;

import java.sql.Array;

public class Solution {

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];

        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        int partSize = length / k;
        int extraParts = length % k;

        current = head;
        for (int i = 0; i < k; i++) {
            result[i] = current;
            int currentPartSize = partSize + (extraParts > 0 ? 1 : 0);
            extraParts--;

            for (int j = 0; j < currentPartSize - 1; j++)
                if (current != null) current = current.next;

            if (current != null) {
                ListNode next = current.next;
                current.next = null;
                current = next;
            }
        }

        return result;
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
