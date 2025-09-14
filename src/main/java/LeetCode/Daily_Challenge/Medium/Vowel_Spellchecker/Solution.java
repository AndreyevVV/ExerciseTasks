package LeetCode.Daily_Challenge.Medium.Vowel_Spellchecker;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    
    private static final Set<Character> VOWELS = Set.of('a','e','i','o','u');
    
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>();
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> devoweled = new HashMap<>();
        
        for (String word : wordlist) {
            exact.add(word);
            String lower = word.toLowerCase();
            caseInsensitive.putIfAbsent(lower, word);
            devoweled.putIfAbsent(devowel(lower), word);
        }
        
        String[] ans = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exact.contains(q)) {
                ans[i] = q;
            } else {
                String lower = q.toLowerCase();
                if (caseInsensitive.containsKey(lower)) {
                    ans[i] = caseInsensitive.get(lower);
                } else {
                    String dv = devowel(lower);
                    ans[i] = devoweled.getOrDefault(dv, "");
                }
            }
        }
        return ans;
    }
    
    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (VOWELS.contains(c)) sb.append('*');
            else sb.append(c);
        }
        return sb.toString();
    }
}
