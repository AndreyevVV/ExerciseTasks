package LeetCode.Daily_Challenge.Medium.Average_Waiting_Time;

public class Solution {

    public double averageWaitingTime(int[][] customers) {
        int currentTime = 0;
        double totalWaitingTime = 0;

        for (int[] customer : customers) {
            int arrivalTime = customer[0];
            int orderTime = customer[1];

            currentTime = Math.max(currentTime, arrivalTime);
            currentTime += orderTime;
            totalWaitingTime += currentTime - arrivalTime;
        }
        return totalWaitingTime / customers.length;
    }
}
