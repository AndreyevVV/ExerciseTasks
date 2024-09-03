package LeetCode.Daily_Challenge.Easy.Sum_of_Digits_of_String_After_Convert;

public class Solution {

    public int getLucky(String s, int k) {
        StringBuilder digits = new StringBuilder();
        for (char c : s.toCharArray()) {
            int value = c - 'a' + 1;
            digits.append(value);
        }

        String numStr = digits.toString();
        int result = 0;
        while (k-- > 0) {
            result = 0;
            for (char c : numStr.toCharArray())
                result += c - '0';
            numStr = String.valueOf(result);
        }

        return result;
    }
}
