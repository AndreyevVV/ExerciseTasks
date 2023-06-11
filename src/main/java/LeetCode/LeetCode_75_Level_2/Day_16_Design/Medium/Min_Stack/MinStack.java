package LeetCode.LeetCode_75_Level_2.Day_16_Design.Medium.Min_Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinStack {
    List<Integer> list;

    public MinStack() {
        list = new ArrayList<>();
    }

    public void push(int val) {
        list.add(val);
    }

    public void pop() {
        list.remove(list.size() - 1);
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        return Collections.min(list);
    }
}
