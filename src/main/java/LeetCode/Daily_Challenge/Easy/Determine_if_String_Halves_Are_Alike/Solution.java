package LeetCode.Daily_Challenge.Easy.Determine_if_String_Halves_Are_Alike;

public class Solution {

    public boolean halvesAreAlike(String s) {
        int length = s.length();
        int countLeft = 0, countRight = 0;
        String vowels = "aeiouAEIOU";

        for (int i = 0, j = length - 1; i < length / 2 && j >= length / 2; i++, j--) {
            if (vowels.indexOf(s.charAt(i)) != -1) countLeft++;
            if (vowels.indexOf(s.charAt(j)) != -1) countRight++;
        }

        return countLeft == countRight;
    }
}
