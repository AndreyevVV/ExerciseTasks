package LeetCode.Daily_Challenge.Medium.Minimum_Length_of_String_After_Operations;

public class Solution {

    public int minimumLength(String s) {
        int totalLength = 0;
        int[] charFrequency = new int[26];

        for (char c : s.toCharArray())
            charFrequency[c - 'a']++;

        for (int frequency : charFrequency)
            if (frequency > 0)
                totalLength += (frequency % 2 == 0) ? 2 : 1;

        return totalLength;
    }
}
