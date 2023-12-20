package LeetCode.Problems.Medium.Integer_to_Roman;

import java.util.Arrays;

public class Solution {

    StringBuilder romanString = new StringBuilder("");

    public String intToRoman(int num) {

        if (num == 0) return romanString.toString();

        Roman roman = Arrays.stream(Roman.values())
                .filter(r -> num >= r.getValue())
                .reduce((a, b) -> b)
                .orElse(null);

        romanString.append(roman.name());

        return intToRoman(num - roman.getValue());
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
