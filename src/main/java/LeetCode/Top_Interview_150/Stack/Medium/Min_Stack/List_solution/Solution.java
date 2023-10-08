package LeetCode.Top_Interview_150.Stack.Medium.Min_Stack.List_solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        MinStack minStack = solution.new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2

    }

    class MinStack {
        List<Integer> stack;

        public MinStack() {
            this.stack = new ArrayList<>();
        }

        public void push(int val) {
            stack.add(val);
        }

        public void pop() {
            if (!stack.isEmpty()) {
                stack.remove(stack.size() - 1);
            }
        }

        public int top() {
            if (stack.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            } else {
                return stack.get(stack.size() - 1);
            }
        }

        public int getMin() {
            return stack.get(stack.indexOf(Collections.min(stack)));
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
}
