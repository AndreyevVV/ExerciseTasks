package LeetCode.Algorithms.Easy.Roman_to_Integer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Solution {

    public int romanToInt(String s) {

        String regex = Arrays.stream(Roman.values())
                .sorted(Comparator.comparingInt(r -> -r.name().length()))
                .map(Enum::name)
                .collect(Collectors.joining("|"));

        Matcher matcher = Pattern.compile(regex).matcher(s);

        return matcher.results()
                .map(e -> Roman.valueOf(e.group()).getValue())
                .reduce(Integer::sum)
                .orElse(0);
    }

    public enum Roman {
        I(1),
        IV(4),
        V(5),
        IX(9),
        X(10),
        XL(40),
        L(50),
        XC(90),
        C(100),
        CD(400),
        D(500),
        CM(900),
        M(1000);

        final int value;

        Roman(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
