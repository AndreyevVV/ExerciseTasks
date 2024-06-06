package LeetCode.Daily_Challenge.Medium.Hand_of_Straights;

import java.util.TreeMap;

public class Solution {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int card : hand)
            map.put(card, map.getOrDefault(card, 0) + 1);

        while (!map.isEmpty()) {
            int firstCard = map.firstKey();
            for (int i = 0; i < groupSize; i++) {
                int currentCard = firstCard + i;
                if (!map.containsKey(currentCard))
                    return false;
                int count = map.get(currentCard);
                if (count == 1)
                    map.remove(currentCard);
                else
                    map.put(currentCard, count - 1);
            }
        }
        return true;
    }
}
