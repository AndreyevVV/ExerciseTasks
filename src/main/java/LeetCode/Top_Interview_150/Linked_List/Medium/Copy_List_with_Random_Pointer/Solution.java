package LeetCode.Top_Interview_150.Linked_List.Medium.Copy_List_with_Random_Pointer;

public class Solution {

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node current = head;
        while (current != null) {
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }

        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        Node newHead = head.next;
        current = head;
        Node newCurrent = newHead;
        while (current != null) {
            current.next = newCurrent.next;
            current = current.next;
            if (current != null) {
                newCurrent.next = current.next;
                newCurrent = newCurrent.next;
            }
        }
        return newHead;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public String toString() {
            return String.format("%s %s %s", val, next, random);
        }
    }
}
