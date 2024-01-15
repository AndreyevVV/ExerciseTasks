package LeetCode.Daily_Challenge.Medium.Find_Players_With_Zero_or_One_Losses;

import java.util.*;
import java.util.function.Function;

public class Solution {

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> lossCount = new HashMap<>();
        Map<Integer, Boolean> played = new HashMap<>();

        for (int[] match : matches) {
            played.put(match[0], true);
            played.put(match[1], true);

            lossCount.put(match[1], lossCount.getOrDefault(match[1], 0) + 1);
        }

        List<Integer> noLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        for (Map.Entry<Integer, Boolean> entry : played.entrySet()) {
            int player = entry.getKey();
            boolean hasPlayed = entry.getValue();

            if (hasPlayed) {
                if (!lossCount.containsKey(player))
                    noLoss.add(player);
                else if (lossCount.get(player) == 1)
                    oneLoss.add(player);
            }
        }

        noLoss.sort(Comparator.comparingInt(Integer::intValue));
        oneLoss.sort(Comparator.comparingInt(Integer::intValue));

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(noLoss);
        answer.add(oneLoss);

        return answer;
    }
}
