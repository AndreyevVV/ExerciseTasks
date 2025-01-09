package LeetCode.Daily_Challenge.Easy.Counting_Words_With_a_Given_Prefix;

public class Solution {

    public int prefixCount(String[] words, String pref) {
        int count = 0;

        for (String word : words)
            if (word.startsWith(pref))
                count++;

        return count;
    }
}
