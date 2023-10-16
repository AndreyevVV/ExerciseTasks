package LeetCode.Top_Interview_150.Linked_List.Medium.Partition_List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().start());
    }

    private ListNode start() {
        int x = 3;

        ListNode six = new ListNode(2);
        ListNode five = new ListNode(5, six);
        ListNode four = new ListNode(2, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(4, three);
        ListNode head = new ListNode(1, two);

        return partition(head, x);
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode smallDummy = new ListNode();
        ListNode start = smallDummy;
        ListNode bigDummy = new ListNode();
        ListNode partitionBoundary = bigDummy;

        while (head != null) {
            if (head.val < x) {
                smallDummy.next = head;
                smallDummy = smallDummy.next;
            } else {
                bigDummy.next = head;
                bigDummy = bigDummy.next;
            }
            head = head.next;
        }

        smallDummy.next = partitionBoundary.next;
        bigDummy.next = null;

        return start.next;
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
