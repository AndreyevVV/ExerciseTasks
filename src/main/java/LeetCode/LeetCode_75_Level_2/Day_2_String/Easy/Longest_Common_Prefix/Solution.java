package LeetCode.LeetCode_75_Level_2.Day_2_String.Easy.Longest_Common_Prefix;

public class Solution {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder answer = new StringBuilder();
        int i = 0;

        while (i < strs[0].length()) {
            int count = 1;

            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || i >= strs[j - 1].length()) break;
                if (strs[j].charAt(i) == strs[j - 1].charAt(i)) count++;
            }
            char character = strs[0].charAt(i++);
            if (count == strs.length) answer.append(character);
            else break;
        }
        return answer.toString();
    }
}
