package LeetCode.Daily_Challenge.Easy.Delete_Characters_to_Make_Fancy_String;

public class Solution {

    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            int resultLength = result.length();

            if (resultLength >= 2
                    && result.charAt(resultLength - 1) == currentChar
                    && result.charAt(resultLength - 2) == currentChar)
                continue;

            result.append(currentChar);
        }

        return result.toString();
    }
}
