package LeetCode.Daily_Challenge.Medium.Reveal_Cards_In_Increasing_Order;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7})));
    }

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        int n = deck.length;
        int[] answer = new int[n];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++)
            queue.add(i);

        for (int card : deck) {
            int idx = queue.poll();
            answer[idx] = card;
            if (!queue.isEmpty())
                queue.add(queue.poll());
        }
        return answer;
    }
}
