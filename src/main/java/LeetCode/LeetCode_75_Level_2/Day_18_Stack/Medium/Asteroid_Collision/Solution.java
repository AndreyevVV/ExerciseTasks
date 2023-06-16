package LeetCode.LeetCode_75_Level_2.Day_18_Stack.Medium.Asteroid_Collision;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().asteroidCollision(new int[]{8, -8})));
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            if (asteroid <= 0) {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) stack.pop();
                if (stack.peek() == Math.abs(asteroid)) stack.pop();
                else if (!stack.isEmpty() && stack.peek() >= Math.abs(asteroid)) continue;
                else stack.push(asteroid);
            } else stack.push(asteroid);
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
