package LeetCode.LeetCode_75_Level_2.Day_16_Design.Easy.Implement_Queue_using_Stacks;

import java.util.Stack;

public class MyQueue {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();

        myQueue.push(1);                // queue is: [1]
        myQueue.push(2);                // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek();                    // return 1
        myQueue.pop();                     // return 1, queue is [2]
        myQueue.empty();                   // return false
    }

    private Stack<Integer> first;
    private Stack<Integer> second;

    public MyQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(int x) {
        if (first.isEmpty()) first.push(x);
        else {
            while (!first.isEmpty()) second.push(first.pop());
            first.push(x);
            while (!second.isEmpty()) first.push(second.pop());
        }
    }

    public int pop() {
        if (!first.isEmpty()) return first.pop();
        return Integer.MIN_VALUE;
    }

    public int peek() {
        if (!first.isEmpty()) return first.peek();
        return Integer.MIN_VALUE;
    }

    public boolean empty() {
        return first.isEmpty();
    }
}
