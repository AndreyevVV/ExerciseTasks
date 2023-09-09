package LeetCode.Top_Interview_150.Array_String.Easy.Length_of_Last_Word;

public class Solution {

    public int lengthOfLastWord(String s) {
        String string = s.trim();
        int i = string.length() - 1, answer = 0;

        while (i >= 0) {
            if (string.charAt(i--) == ' ') break;
            answer++;
        }
        return answer;
    }
}
