package LeetCode.Problems.Easy.Convert_Binary_Number_in_a_Linked_List_to_Integer.Stack_solution;

import LeetCode.Problems.Easy.Convert_Binary_Number_in_a_Linked_List_to_Integer.ListNode;

import java.util.Stack;

public class Solution {

    public int getDecimalValue(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int answer = 0;
        int i = 0;

        while (!stack.isEmpty())
            answer += stack.pop() * Math.pow(2, i++);

        return answer;
    }
}
