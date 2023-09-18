package LeetCode.Top_Interview_150.Array_String.Medium.Gas_Station;

public class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int commonBalance = 0, station = 0, tank = 0;
        for (int i = 0; i < gas.length; i++) {
            int balance = gas[i] - cost[i];
            commonBalance += balance;
            tank += balance;
            if (tank < 0) {
                station = i + 1;
                tank = 0;
            }
        }
        return commonBalance < 0 ? -1 : station;
    }
}
