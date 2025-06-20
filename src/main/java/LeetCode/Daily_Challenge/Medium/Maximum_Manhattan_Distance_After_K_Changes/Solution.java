package LeetCode.Daily_Challenge.Medium.Maximum_Manhattan_Distance_After_K_Changes;

public class Solution {

    public int maxDistance(String s, int k) {
        int ans = 0;
        int north = 0, south = 0, east = 0, west = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'N':
                    north++;
                    break;
                case 'S':
                    south++;
                    break;
                case 'E':
                    east++;
                    break;
                case 'W':
                    west++;
                    break;
            }

            int northSouthDiff = Math.abs(north - south);
            int eastWestDiff = Math.abs(east - west);
            int manhattan = northSouthDiff + eastWestDiff;

            int stepsTaken = i + 1;
            int maxPossibleChange = Math.min(2 * k, stepsTaken - manhattan);
            int currentDist = manhattan + maxPossibleChange;

            ans = Math.max(ans, currentDist);
        }

        return ans;
    }
}
