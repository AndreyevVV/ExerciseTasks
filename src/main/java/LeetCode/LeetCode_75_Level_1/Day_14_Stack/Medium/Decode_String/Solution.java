package LeetCode.LeetCode_75_Level_1.Day_14_Stack.Medium.Decode_String;

import java.util.Stack;

public class Solution {

    public String decodeString(String s) {

        Stack<Integer> repCounter = new Stack<>();
        Stack<StringBuilder> symbols = new Stack<>();

        int n = s.length(), counter = 0;
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < n; i++) {

            if (Character.isDigit(s.charAt(i))) {
                counter = counter * 10 + s.charAt(i) - '0';;
            } else if (s.charAt(i) == '[') {
                symbols.push(str);

                str = new StringBuilder();

                repCounter.push(counter);
                counter = 0;
            } else if (s.charAt(i) == ']') {
                StringBuilder repeatedPart = str;
                str = symbols.pop();

                int count = repCounter.pop();

                while (count-- > 0) {
                    str.append(repeatedPart);
                }
            } else {
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }
}
