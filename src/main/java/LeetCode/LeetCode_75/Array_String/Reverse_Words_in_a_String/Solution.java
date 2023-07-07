package LeetCode.LeetCode_75.Array_String.Reverse_Words_in_a_String;

import java.util.Collections;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public String reverseWords(String s) {
        Matcher matcher = Pattern.compile("[a-zA-Z0-9]+").matcher(s);

        return matcher.results()
                .map(MatchResult::group)
                .reduce((word1, word2) -> word2 + " " + word1)
                .orElse("");
    }
}
