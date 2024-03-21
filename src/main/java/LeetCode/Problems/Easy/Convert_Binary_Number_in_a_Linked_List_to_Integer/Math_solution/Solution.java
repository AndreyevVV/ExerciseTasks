package LeetCode.Problems.Easy.Convert_Binary_Number_in_a_Linked_List_to_Integer.Math_solution;

import LeetCode.Problems.Easy.Convert_Binary_Number_in_a_Linked_List_to_Integer.ListNode;

public class Solution {

    public int getDecimalValue(ListNode head) {
        int ans = 0;

        while (head != null) {
            ans = 2 * ans + head.val;
            head = head.next;
        }
        return ans;
    }
}
