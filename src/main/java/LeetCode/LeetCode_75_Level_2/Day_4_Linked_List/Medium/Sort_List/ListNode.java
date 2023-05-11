package LeetCode.LeetCode_75_Level_2.Day_4_Linked_List.Medium.Sort_List;


public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val + " " + next;
    }
}
