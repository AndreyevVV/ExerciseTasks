package LeetCode.Daily_Challenge.Medium.Find_the_Lexicographically_Largest_String_From_the_Box_I;

public class Solution {

    public String answerString(String word, int numFriends) {
        if (numFriends == 1) return word;

        String result = "";
        int maxLen = word.length() - numFriends + 1;

        for (int i = 0; i <= word.length() - maxLen; i++) {
            String candidate = word.substring(i, i + maxLen);
            if (candidate.compareTo(result) > 0)
                result = candidate;
        }

        return result;
    }
}
