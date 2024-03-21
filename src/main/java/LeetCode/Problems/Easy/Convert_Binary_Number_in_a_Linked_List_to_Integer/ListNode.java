package LeetCode.Problems.Easy.Convert_Binary_Number_in_a_Linked_List_to_Integer;

public class ListNode {
    public int val;
    public ListNode next;

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
