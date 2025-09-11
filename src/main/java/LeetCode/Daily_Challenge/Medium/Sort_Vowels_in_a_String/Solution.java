package LeetCode.Daily_Challenge.Medium.Sort_Vowels_in_a_String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Solution {
    
    private static final Set<Character> VOWELS = Set.of(
        'a','e','i','o','u','A','E','I','O','U'
    );

    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        
        for (char c : s.toCharArray())
            if (VOWELS.contains(c))
                vowels.add(c);
        
        Collections.sort(vowels);
        
        StringBuilder result = new StringBuilder();
        int idx = 0;
        
        for (char c : s.toCharArray()) {
            if (VOWELS.contains(c))
                result.append(vowels.get(idx++));
            else
                result.append(c);
        }
        
        return result.toString();
    }
}
