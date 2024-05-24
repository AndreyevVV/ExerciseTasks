package LeetCode.Daily_Challenge.Hard.Maximum_Score_Words_Formed_by_Letters;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String[] words1 = {"dog", "cat", "dad", "good"};
        char[] letters1 = {'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'};
        int[] score1 = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(maxScoreWords(words1, letters1, score1));  // Output: 23

        String[] words2 = {"xxxz", "ax", "bx", "cx"};
        char[] letters2 = {'z', 'a', 'b', 'c', 'x', 'x', 'x'};
        int[] score2 = {4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10};
        System.out.println(maxScoreWords(words2, letters2, score2));  // Output: 27

        String[] words3 = {"leetcode"};
        char[] letters3 = {'l', 'e', 't', 'c', 'o', 'd'};
        int[] score3 = {0,0,1,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0};
        System.out.println(maxScoreWords(words3, letters3, score3));  // Output: 0
    }

    public static int maxScoreWords(String[] words, char[] letters, int[] score) {
        Map<Character, Integer> letterCount = new HashMap<>();
        for (char letter : letters) {
            letterCount.put(letter, letterCount.getOrDefault(letter, 0) + 1);
        }

        int[] totalScore = new int[1];

        explore(words, letterCount, score, 0, 0, totalScore);

        return totalScore[0];
    }

    private static void explore(String[] words, Map<Character, Integer> letterCount, int[] score, int index, int currentScore,
                                int[] totalScore) {
        totalScore[0] = Math.max(totalScore[0], currentScore);

        if (index == words.length) {
            return;
        }

        for (int i = index; i < words.length; i++) {
            Map<Character, Integer> tempCount = new HashMap<>(letterCount);
            String word = words[i];
            int wordScore = 0;
            boolean isValid = true;

            for (char c : word.toCharArray()) {
                if (tempCount.getOrDefault(c, 0) > 0) {
                    tempCount.put(c, tempCount.get(c) - 1);
                    wordScore += score[c - 'a'];
                } else {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                explore(words, tempCount, score, i + 1, currentScore + wordScore, totalScore);
            }
        }
    }
}
