package LeetCode.Daily_Challenge.Easy.Count_the_Number_of_Consistent_Strings;

public class Solution {

    public int countConsistentStrings(String allowed, String[] words) {
        int allowedMask = 0;
        for (char ch : allowed.toCharArray())
            allowedMask |= (1 << (ch - 'a'));

        int count = 0;
        for (String word : words) {
            int wordMask = 0;
            for (char ch : word.toCharArray())
                wordMask |= (1 << (ch - 'a'));

            if ((wordMask & ~allowedMask) == 0)
                count++;
        }

        return count;
    }
}
