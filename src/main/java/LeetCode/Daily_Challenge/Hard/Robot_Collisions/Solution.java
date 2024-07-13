package LeetCode.Daily_Challenge.Hard.Robot_Collisions;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] positions = {1, 2, 3, 4, 5};
        int[] healths = {10, 20, 30, 40, 50};
        String directions = "RLRRL";

        List<Integer> survivors = new Solution().survivedRobotsHealths(positions, healths, directions);
        System.out.println(survivors);
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<Robot> robots = new ArrayList<>();

        for (int i = 0; i < n; i++)
            robots.add(new Robot(i, positions[i], healths[i], directions.charAt(i)));

        robots.sort(Comparator.comparingInt(r -> r.position));

        Stack<Robot> stack = new Stack<>();
        for (Robot robot : robots) {
            if (robot.direction == 'R') {
                stack.push(robot);
            } else {
                while (!stack.isEmpty() && stack.peek().direction == 'R') {
                    Robot rightRobot = stack.pop();
                    if (rightRobot.health > robot.health) {
                        rightRobot.health--;
                        robot = null;
                        stack.push(rightRobot);
                        break;
                    } else if (rightRobot.health < robot.health) {
                        robot.health--;
                    } else {
                        robot = null;
                        break;
                    }
                }
                if (robot != null)
                    stack.push(robot);
            }
        }

        int[] result = new int[n];
        Arrays.fill(result, -1);

        for (Robot robot : stack)
            result[robot.index] = robot.health;

        List<Integer> survivors = new ArrayList<>();
        for (int health : result)
            if (health != -1)
                survivors.add(health);

        return survivors;
    }

    class Robot {
        int index;
        int position;
        int health;
        char direction;

        Robot(int index, int position, int health, char direction) {
            this.index = index;
            this.position = position;
            this.health = health;
            this.direction = direction;
        }
    }
}
