package LeetCode.Daily_Challenge.Easy.Rotate_String;

public class Solution {

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length())
            return false;

        return (s + s).contains(goal);
    }
}
