package LeetCode.LeetCode_75.Heap_Priority_Queue.Medium.Total_Cost_to_Hire_K_Workers;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public long totalCost(int[] costs, int k, int candidates) {
        Queue<Integer> queue1 = new PriorityQueue<>();
        Queue<Integer> queue2 = new PriorityQueue<>();

        int i = 0;
        int length = costs.length - 1;

        long totalCost = 0;
        while (k > 0) {
            while (queue1.size() < candidates && i <= length)
                queue1.offer(costs[i++]);
            while (queue2.size() < candidates && i <= length)
                queue2.offer(costs[length--]);

            int lowestFromQ1 = queue1.size() > 0 ? queue1.peek() : Integer.MAX_VALUE;
            int lowestFromQ2 = queue2.size() > 0 ? queue2.peek() : Integer.MAX_VALUE;

            if (lowestFromQ1 <= lowestFromQ2) {
                totalCost += lowestFromQ1;
                queue1.poll();
            } else {
                totalCost += lowestFromQ2;
                queue2.poll();
            }
            k--;
        }
        return totalCost;
    }
}
