package LeetCode.LeetCode_75_Level_2.Day_4_Linked_List.Medium.Sort_List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) return head;

        ArrayList<Integer> list = new ArrayList<>();
        ListNode start = head;

        while (start != null) {
            list.add(start.val);
            start = start.next;
        }

        Collections.sort(list);
        start = head;

        for (int num : list) {
            start.val = num;
            start = start.next;
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
            return val + " " + next;
        }
    }
}
