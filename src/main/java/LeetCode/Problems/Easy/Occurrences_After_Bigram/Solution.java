package LeetCode.Problems.Easy.Occurrences_After_Bigram;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public String[] findOcurrences(String text, String first, String second) {

        String regex = String.format("(?<=\\b%s\\s%s\\s)\\w+", first, second);
        Matcher matcher = Pattern.compile(regex).matcher(text);

        return matcher.results().map(MatchResult::group).toArray(String[]::new);
    }
}
