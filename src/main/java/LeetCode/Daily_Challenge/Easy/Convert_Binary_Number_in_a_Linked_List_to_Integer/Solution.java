package LeetCode.Daily_Challenge.Easy.Convert_Binary_Number_in_a_Linked_List_to_Integer;

public class Solution {
    
    public int getDecimalValue(ListNode head) {
        int result = 0;
        while (head != null) {
            result = (result << 1) | head.val;
            head = head.next;
        }
        return result;
    }

    public class ListNode {
        int val; 
        ListNode next; 
        ListNode() {} 
        ListNode(int val) { this.val = val; } 
        ListNode(int val, ListNode next) { this.val = val; this.next = next; } 
    }
}
