package LeetCode.Daily_Challenge.Medium.Minimum_Length_of_String_After_Deleting_Similar_Ends;

public class Solution {

    public int minimumLength(String s) {
        while (true) {
            int length = s.length();
            s = removePrefixAndSuffix(s);
            if (s.length() == length)
                break;
        }
        return s.length();
    }

    private static String removePrefixAndSuffix(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j && s.charAt(i) == s.charAt(j)) {
            char target = s.charAt(i);
            while (i <= j && s.charAt(i) == target)
                i++;
            while (i <= j && s.charAt(j) == target)
                j--;
        }

        if (i <= j)
            return s.substring(i, j + 1);
        else
            return "";
    }
}
