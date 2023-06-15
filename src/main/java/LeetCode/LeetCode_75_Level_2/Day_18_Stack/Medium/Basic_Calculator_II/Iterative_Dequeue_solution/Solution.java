package LeetCode.LeetCode_75_Level_2.Day_18_Stack.Medium.Basic_Calculator_II.Iterative_Dequeue_solution;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    int p = 0;

    public int calculate(String s) {
        int num = 0;
        char operand = '+';
        Deque<Integer> queue = new LinkedList<>();
        queue.push(0);
        s = s.replace(" ", "");

        while (p < s.length()) {
            char c = s.charAt(p);
            if (c <= '9' && c >= '0') {
                num = num * 10 + (c - '0');
            } else {
                if (c == '(') {
                    p++;
                    num = calculate(s);
                } else if (c == ')') {
                    processQue(queue, operand, num);
                    return getAns(queue);
                } else {
                    processQue(queue, operand, num);
                    num = 0;
                    operand = c;
                }
            }
            if (p == s.length() - 1) processQue(queue, operand, num);
            p++;
        }
        return getAns(queue);
    }

    private void processQue(Deque<Integer> q, char op, int num) {
        switch (op) {
            case '+':
                q.push(num);
                break;
            case '-':
                q.push(-num);
                break;
            case '*':
                q.push(q.poll() * num);
                break;
            case '/':
                q.push(q.poll() / num);
                break;
        }
    }

    private int getAns(Deque<Integer> q) {
        int ans = 0;
        while (!q.isEmpty()) {
            ans += q.poll();
        }
        return ans;
    }
}