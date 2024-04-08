package LeetCode.Daily_Challenge.Easy.Number_of_Students_Unable_to_Eat_Lunch;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}));
    }

    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = Arrays.stream(students).boxed().collect(Collectors.toCollection(LinkedList::new));

        Stack<Integer> stack = Arrays.stream(sandwiches).boxed()
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                    Collections.reverse(list);
                    return list.stream();
                }))
                .collect(Collectors.toCollection(Stack::new));
        /*
        Stack<Integer> stack = new Stack<>();
        for (int i = sandwiches.length - 1; i >= 0; i--)
            stack.push(sandwiches[i]);
        */

        while (!queue.isEmpty() && !stack.isEmpty()) {
            int queueSize = queue.size();
            int stackSize = stack.size();

            for (int i = 0; i < queueSize; i++) {
                if (queue.peek().equals(stack.peek())) {
                    queue.poll();
                    stack.pop();
                    continue;
                }
                queue.offer(queue.poll());
            }
            if (stackSize == stack.size()) return queueSize;
        }
        return queue.size();
    }
}
