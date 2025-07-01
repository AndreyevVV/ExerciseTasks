package LeetCode.Daily_Challenge.Easy.Find_the_Original_Typed_String_I;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int possibleStringCount(String word) {
        List<Integer> groupLengths = new ArrayList<>();
        int n = word.length();
        int i = 0;

        while (i < n) {
            int j = i;
            while (j < n && word.charAt(j) == word.charAt(i))
                j++;
            groupLengths.add(j - i);
            i = j;
        }

        int count = 1;

        for (int len : groupLengths)
            if (len > 1)
                count += (len - 1);

        return count;
    }
}
