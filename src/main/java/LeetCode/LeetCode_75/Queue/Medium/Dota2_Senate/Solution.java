package LeetCode.LeetCode_75.Queue.Medium.Dota2_Senate;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public String predictPartyVictory(String senate) {
        int processLength = 2 * senate.length();
        int radiant = 0;
        int dire = 0;

        Queue<Character> queue = new LinkedList<>();
        for (char senator : senate.toCharArray()) queue.add(senator);

        for (int i = 0; i < processLength; i++) {
            if (queue.peek() == 'R') {
                if (dire == 0) {
                    radiant++;
                    queue.remove();
                    queue.add('R');
                } else {
                    dire--;
                    queue.remove();
                }
            } else {
                if (radiant == 0) {
                    dire++;
                    queue.remove();
                    queue.add('D');
                } else {
                    radiant--;
                    queue.remove();
                }
            }
        }
        return queue.peek() == 'D' ? "Dire" : "Radiant";
    }
}
