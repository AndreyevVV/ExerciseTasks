package LeetCode.Daily_Challenge.Easy.Score_of_a_String;

public class Solution {

    public int scoreOfString(String s) {
        if (s == null || s.length() < 2)
            return 0;

        int diff = Math.abs(s.charAt(0) - s.charAt(1));

        return diff + scoreOfString(s.substring(1));
    }
}
