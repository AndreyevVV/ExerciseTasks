package LeetCode.Daily_Challenge.Medium.Remove_All_Occurrences_of_a_Substring;

public class Solution {

    public String removeOccurrences(String s, String part) {
        while (s.contains(part))
            s = s.replaceFirst(part, "");
        return s;
    }
}
