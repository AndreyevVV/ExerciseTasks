package LeetCode.Problems.Easy.X_of_a_Kind_in_a_Deck_of_Cards;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int card : deck)
            count.put(card, count.getOrDefault(card, 0) + 1);

        int gcd = 0;
        for (int freq : count.values())
            gcd = gcd == 0 ? freq : gcd(gcd, freq);

        return gcd > 1;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
