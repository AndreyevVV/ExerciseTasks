package LeetCode.Daily_Challenge.Easy.Time_Needed_to_Buy_Tickets;

public class Solution {

    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int time = 0;

        while (true) {
            for (int i = 0; i < n; i++) {
                if (tickets[i] > 0) {
                    tickets[i] = tickets[i] - 1;
                    time++;
                }
                if (i == k && tickets[i] == 0)
                    return time;
            }
        }
    }
}
