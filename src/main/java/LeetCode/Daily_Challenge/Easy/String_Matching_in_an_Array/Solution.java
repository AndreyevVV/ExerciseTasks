package LeetCode.Daily_Challenge.Easy.String_Matching_in_an_Array;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++)
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
        }

        return result;
    }
}
