package LeetCode.Daily_Challenge.Hard.Meeting_Rooms_III.BruteForce_solution;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int mostBooked(int totalRooms, int[][] meetings) {
        int[] meetingCounts = new int[totalRooms]; 
        long[] roomAvailability = new long[totalRooms];

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            boolean isAssigned = false;
            int earliestFreeRoom = -1;
            long earliestTime = Long.MAX_VALUE;

            for (int i = 0; i < totalRooms; i++) {
                if (roomAvailability[i] < earliestTime) {
                    earliestTime = roomAvailability[i];
                    earliestFreeRoom = i;
                }

                if (roomAvailability[i] <= start) {
                    roomAvailability[i] = end;
                    meetingCounts[i]++;
                    isAssigned = true;
                    break;
                }
            }

            if (!isAssigned) {
                roomAvailability[earliestFreeRoom] += (end - start);
                meetingCounts[earliestFreeRoom]++;
            }
        }

        int maxMeetings = 0;
        int resultRoom = 0;
        for (int i = 0; i < totalRooms; i++) {
            if (meetingCounts[i] > maxMeetings) {
                maxMeetings = meetingCounts[i];
                resultRoom = i;
            }
        }

        return resultRoom;
    }
}
