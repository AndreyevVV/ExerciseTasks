package LeetCode.Daily_Challenge.Hard.Word_Break_II;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        new Solution().start();
    }

    public void start() {
        String s1 = "catsanddog";
        List<String> wordDict1 = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println(wordBreak(s1, wordDict1));

        String s2 = "pineapplepenapple";
        List<String> wordDict2 = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        System.out.println(wordBreak(s2, wordDict2));

        String s3 = "catsandog";
        List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(wordBreak(s3, wordDict3));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();
        return wordBreakHelper(s, wordSet, memo);
    }

    private static List<String> wordBreakHelper(String s, Set<String> wordSet, Map<String, List<String>> memo) {
        if (memo.containsKey(s))
            return memo.get(s);

        List<String> results = new ArrayList<>();
        if (s.isEmpty()) {
            results.add("");
            return results;
        }

        for (String word : wordSet) {
            if (s.startsWith(word)) {
                String remaining = s.substring(word.length());
                List<String> subResults = wordBreakHelper(remaining, wordSet, memo);
                for (String subResult : subResults) {
                    String space = subResult.isEmpty() ? "" : " ";
                    results.add(word + space + subResult);
                }
            }
        }

        memo.put(s, results);
        return results;
    }
}
