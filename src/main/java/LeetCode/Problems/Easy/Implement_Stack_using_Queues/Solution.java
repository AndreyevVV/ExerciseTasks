package LeetCode.Problems.Easy.Implement_Stack_using_Queues;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    class MyStack {

        private Queue<Integer> queue1;
        private Queue<Integer> queue2;
        private int top;

        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        public void push(int x) {
            queue2.offer(x);
            while (!queue1.isEmpty())
                queue2.offer(queue1.poll());
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
            top = x;
        }

        public int pop() {
            int popped = queue1.poll();
            if (queue1.isEmpty())
                top = 0;
            else
                top = queue1.peek();
            return popped;
        }

        public int top() {
            return top;
        }

        public boolean empty() {
            return queue1.isEmpty();
        }
    }

    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
}
