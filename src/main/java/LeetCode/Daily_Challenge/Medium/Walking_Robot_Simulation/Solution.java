package LeetCode.Daily_Challenge.Medium.Walking_Robot_Simulation;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles)
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);

        int x = 0, y = 0;
        int direction = 0;
        int maxDistanceSquared = 0;

        for (int command : commands) {
            if (command == -2) {
                direction = (direction + 3) % 4;
            } else if (command == -1) {
                direction = (direction + 1) % 4;
            } else {
                for (int i = 0; i < command; i++) {
                    int nextX = x + dx[direction];
                    int nextY = y + dy[direction];

                    if (obstacleSet.contains(nextX + "," + nextY))
                        break;

                    x = nextX;
                    y = nextY;
                    maxDistanceSquared = Math.max(maxDistanceSquared, x * x + y * y);
                }
            }
        }

        return maxDistanceSquared;
    }
}
