package LeetCode.Daily_Challenge.Hard.Meeting_Rooms_III;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public int mostBooked(int totalRooms, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> meetingQueue = new PriorityQueue<>((a, b) -> (a[1] == b[1]) ? a[0] - b[0] : a[1] - b[1]);
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();

        for (int i = 0; i < totalRooms; i++)
            freeRooms.offer(i);

        int[] meetingCountPerRoom = new int[totalRooms];

        for (int i = 0; i < meetings.length; i++) {
            releaseRooms(meetingQueue, freeRooms, meetings[i][0]);

            if (freeRooms.isEmpty()) {
                int[] room = meetingQueue.poll();
                meetingCountPerRoom[room[0]]++;
                meetingQueue.offer(new int[]{room[0], room[1] + meetings[i][1] - meetings[i][0]});
            } else {
                int room = freeRooms.poll();
                meetingCountPerRoom[room]++;
                meetingQueue.offer(new int[]{room, meetings[i][1]});
            }
        }
        return findMostBookedRoom(meetingCountPerRoom);
    }

    private void releaseRooms(PriorityQueue<int[]> meetingQueue, PriorityQueue<Integer> freeRooms, int startTime) {
        while (!meetingQueue.isEmpty() && meetingQueue.peek()[1] <= startTime)
            freeRooms.offer(meetingQueue.poll()[0]);
    }

    private int findMostBookedRoom(int[] meetingCountPerRoom) {
        int maxCount = Integer.MIN_VALUE, mostBookedRoom = 0;

        for (int i = 0; i < meetingCountPerRoom.length; i++) {
            if (meetingCountPerRoom[i] > maxCount) {
                maxCount = meetingCountPerRoom[i];
                mostBookedRoom = i;
            }
        }
        return mostBookedRoom;
    }
}
