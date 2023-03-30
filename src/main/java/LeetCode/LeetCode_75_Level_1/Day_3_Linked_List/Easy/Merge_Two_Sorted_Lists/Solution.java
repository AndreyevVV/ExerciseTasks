package LeetCode.LeetCode_75_Level_1.Day_3_Linked_List.Easy.Merge_Two_Sorted_Lists;

import java.util.List;

public class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode pointerToNext = new ListNode(-1);
        ListNode newHead = pointerToNext;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                newHead.next = list1;
                list1 = list1.next;
            } else {
                newHead.next = list2;
                list2 = list2.next;
            }
            newHead = newHead.next;
        }

        if (list1 == null) newHead.next = list2;
        else newHead.next = list1;

        return pointerToNext.next;
    }

    private static class ListNode {
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
