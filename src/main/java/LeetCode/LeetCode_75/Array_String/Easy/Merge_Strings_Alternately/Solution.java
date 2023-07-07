package LeetCode.LeetCode_75.Array_String.Easy.Merge_Strings_Alternately;

public class Solution {

    public String mergeAlternately(String word, String word2) {
        StringBuilder answer = new StringBuilder();
        int length1 = word.length(), length2 = word2.length();
        int i = 0, j = 0;

        while (i < length1 || j < length2) {
            if(i<length1) answer.append(word.charAt(i++));
            if(j<length2) answer.append(word2.charAt(j++));
        }
        return answer.toString();
    }
}
