package LeetCode.LeetCode_75_Level_1.Day_13_Hashmap.Medium.Bulls_and_Cows;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String getHint(String secret, String guess) {

        int x = 0;
        int[] y = {0};

        Map<Character, Integer> secretMap = new HashMap<>();
        Map<Character, Integer> guessMap = new HashMap<>();

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) x++;
            else {
                secretMap.put(secret.charAt(i), secretMap.getOrDefault(secret.charAt(i), 0) + 1);
                guessMap.put(guess.charAt(i), guessMap.getOrDefault(guess.charAt(i), 0) + 1);
            }
        }

        secretMap.forEach((k, v) -> {
            if (guessMap.containsKey(k)) {
                if (guessMap.get(k) >= v) y[0] += v;
                else y[0] += guessMap.get(k);
            }
        });
        return String.format("%dA%dB", x, y[0]);
    }
}
