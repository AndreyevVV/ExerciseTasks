package LeetCode.Daily_Challenge.Medium.Merge_In_Between_Linked_Lists;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().start());
    }

    private ListNode start() {

        ListNode list1_5 = new ListNode(5);
        ListNode list1_4 = new ListNode(9, list1_5);
        ListNode list1_3 = new ListNode(6, list1_4);
        ListNode list1_2 = new ListNode(13, list1_3);
        ListNode list1_1 = new ListNode(1, list1_2);
        ListNode list1_0 = new ListNode(10, list1_1);

        ListNode list2_2 = new ListNode(1000002);
        ListNode list2_1 = new ListNode(1000001, list2_2);
        ListNode list2_0 = new ListNode(1000000, list2_1);

        return mergeInBetween(list1_0, 3, 4, list2_0);
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode indexA = list1;
        ListNode indexB = list1;
        ListNode dummy = list2;
        b += 1;

        while (a-- > 0 | b-- > 0 || dummy.next != null) {
            if(a > 0) indexA = indexA.next;
            if(b > 0) indexB = indexB.next;
            if (dummy.next != null) dummy = dummy.next;
        }

        indexA.next = list2;
        dummy.next = indexB.next;
        indexB.next = null;

        return list1;
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
            return String.format("%s %s", val, next);
        }
    }
}
