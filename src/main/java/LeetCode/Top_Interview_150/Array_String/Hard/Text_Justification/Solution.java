package LeetCode.Top_Interview_150.Array_String.Hard.Text_Justification;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int lineLength = 0;
            int lastWordIndex = index;

            while (lastWordIndex < words.length &&
                    lineLength + words[lastWordIndex].length() + (lastWordIndex - index) <= maxWidth) {
                lineLength += words[lastWordIndex].length();
                lastWordIndex++;
            }

            int numWords = lastWordIndex - index;
            int numSpaces = maxWidth - lineLength;

            StringBuilder line = new StringBuilder(words[index]);

            if (numWords > 1 && lastWordIndex < words.length) {
                int spacesPerSlot = numSpaces / (numWords - 1);
                int extraSpaces = numSpaces % (numWords - 1);

                for (int i = index + 1; i < lastWordIndex; i++) {
                    int spaces = spacesPerSlot + (i - index <= extraSpaces ? 1 : 0);
                    for (int j = 0; j < spaces; j++) {
                        line.append(" ");
                    }
                    line.append(words[i]);
                }
            } else {
                for (int i = index + 1; i < lastWordIndex; i++) {
                    line.append(" ").append(words[i]);
                }
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            }

            result.add(line.toString());
            index = lastWordIndex;
        }
        return result;
    }
}
