package LeetCode.Daily_Challenge.Hard.Sliding_Puzzle;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public int slidingPuzzle(int[][] board) {
        String target = "123450";

        StringBuilder start = new StringBuilder();

        for (int[] row : board)
            for (int num : row)
                start.append(num);

        int[][] directions = {
                {1, 3},
                {0, 2, 4},
                {1, 5},
                {0, 4},
                {1, 3, 5},
                {2, 4}
        };

        Queue<String> queue = new LinkedList<>();
        queue.offer(start.toString());

        Set<String> visited = new HashSet<>();
        visited.add(start.toString());

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (current.equals(target))
                    return moves;

                int zeroIndex = current.indexOf('0');

                for (int next : directions[zeroIndex]) {
                    String nextState = swap(current, zeroIndex, next);

                    if (visited.add(nextState))
                        queue.offer(nextState);
                }
            }
            moves++;
        }

        return -1;
    }

    private String swap(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}
