package LeetCode.Daily_Challenge.Easy.Minimum_Number_of_Moves_to_Seat_Everyone;

import java.util.Arrays;

public class Solution {

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int totalMoves = 0;

        for (int i = 0; i < seats.length; i++)
            totalMoves += Math.abs(seats[i] - students[i]);

        return totalMoves;
    }
}
