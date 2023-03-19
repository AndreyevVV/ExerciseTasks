package LeetCode.Algorithms.Easy.Divide_a_String_Into_Groups_of_Size_k;

import java.util.Arrays;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public String[] divideString(String s, int k, char fill) {

        StringBuilder string = new StringBuilder(s);
        int symbolsToFill = k - (s.length() % k);

        if (symbolsToFill < k) {
            string.append(String.valueOf(fill).repeat(Math.max(0, symbolsToFill)));
        }

        Matcher matcher = Pattern.compile("[a-zA-Z]" + "{" + k + "}").matcher(string);

        return  matcher.results()
                .map(MatchResult::group)
                .toArray(String[]::new);
    }
}
