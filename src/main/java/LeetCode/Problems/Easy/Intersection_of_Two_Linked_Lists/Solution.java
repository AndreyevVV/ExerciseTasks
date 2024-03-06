package LeetCode.Problems.Easy.Intersection_of_Two_Linked_Lists;

import java.util.*;

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> setA = new HashSet<>();
        Set<ListNode> setB = new HashSet<>();

        while (headA != null || headB != null) {
            setA.add(headA);
            setB.add(headB);

            if (setA.contains(headB)) return headB;
            if (setB.contains(headA)) return headA;


            if (headA != null) headA = headA.next;
            if (headB != null) headB = headB.next;
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
