package LeetCode.Daily_Challenge.Medium.The_Number_of_the_Smallest_Unoccupied_Chair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;

        int[][] events = new int[n][3];

        for (int i = 0; i < n; i++)
            events[i] = new int[] { times[i][0], i, 0 };

        PriorityQueue<Integer> freeChairs = new PriorityQueue<>();
        for (int i = 0; i < n; i++)
            freeChairs.offer(i);

        PriorityQueue<int[]> occupiedChairs = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        for (int[] event : events) {
            int time = event[0];
            int friendIndex = event[1];

            while (!occupiedChairs.isEmpty() && occupiedChairs.peek()[0] <= time)
                freeChairs.offer(occupiedChairs.poll()[1]);

            int chair = freeChairs.poll();

            if (friendIndex == targetFriend)
                return chair;

            occupiedChairs.offer(new int[] { times[friendIndex][1], chair });
        }

        return -1;
    }
}
