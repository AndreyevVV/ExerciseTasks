package LeetCode.Problems.Easy.Rings_and_Rods;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Solution {

    public int countPoints(String rings) {

        Pattern pattern = Pattern.compile("[rgbRGB]\\d");
        Matcher matcher = pattern.matcher(rings);

        return (int) matcher.results()
                .map(MatchResult::group)
                .collect(Collectors.groupingBy(e -> Character.getNumericValue(e.charAt(1)), Collectors.toSet()))
                .entrySet().stream()
                .filter(e -> e.getValue().size() == 3)
                .count();
    }
}
