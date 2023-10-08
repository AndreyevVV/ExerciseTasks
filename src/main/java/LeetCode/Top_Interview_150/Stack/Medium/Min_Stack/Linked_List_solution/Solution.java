package LeetCode.Top_Interview_150.Stack.Medium.Min_Stack.Linked_List_solution;

public class Solution {

    class MinStack {
        private Node head;

        public MinStack() {
            this.head = null;
        }
        public void push(int value) {
            if (head == null)
                head = new Node(value, value, null);
            else
                head = new Node(value, Math.min(value, head.min), head);
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }

        private class Node {
            int val;
            int min;
            Node next;

            private Node(int val, int min, Node next) {
                this.val = val;
                this.min = min;
                this.next = next;
            }
        }
    }
}
