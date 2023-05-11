package LeetCode.LeetCode_75_Level_2.Day_4_Linked_List.Medium.Sort_List.Naive_solution;

import LeetCode.LeetCode_75_Level_2.Day_4_Linked_List.Medium.Sort_List.ListNode;

import java.util.ArrayList;
import java.util.Collections;

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
}
