package LeetCode.Problems.Easy.Roman_to_Integer;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Solution {

    static Map<String, Integer> romanMap = new LinkedHashMap<>() {{
        put("M", 1000); put("CM", 900); put("D", 500); put("CD", 400); put("C", 100);
        put("XC", 90); put("L", 50); put("XL", 40); put("X", 10);
        put("IX", 9); put("V", 5); put("IV", 4); put("I", 1);
    }};

    public int romanToInt(String s) {
        if (s.length() == 0) {
            return 0;
        }

        return romanMap.entrySet().stream()
                .filter(d -> s.startsWith(d.getKey()))
                .map(d -> d.getValue() + romanToInt(s.substring(d.getKey().length())))
                .findFirst()
                .orElse(0);
    }

    public int romanToIntWithRegex(String s) {

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
