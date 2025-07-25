package LeetCode.Daily_Challenge.Medium.Maximum_Number_of_Events_That_Can_Be_Attended;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int day = 0, i = 0, n = events.length, count = 0;

        while (i < n || !pq.isEmpty()) {
            if (pq.isEmpty())
                day = events[i][0];

            while (i < n && events[i][0] == day) {
                pq.offer(events[i][1]);
                i++;
            }

            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                pq.poll();
                count++;
                day++;
            }
        }

        return count;
    }    
}
