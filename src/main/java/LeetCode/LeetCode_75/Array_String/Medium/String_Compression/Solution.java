package LeetCode.LeetCode_75.Array_String.Medium.String_Compression;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().compress(new char[]{'a', 'a'}));
    }

    public int compress(char[] chars) {
        int startIndex = 0;
        int[] answerCount = {0};
        int n = chars.length;

        while (startIndex < n) {
            int endIndex = startIndex + 1;

            while (endIndex < n && chars[startIndex] == chars[endIndex]) {
                endIndex++;
            }

            chars[answerCount[0]++] = chars[startIndex];
            int count = endIndex - startIndex;

            if (count > 1) {
                String cht = String.valueOf(count);
                cht.chars().forEach(character -> chars[answerCount[0]++] = (char) character);
            }

            startIndex = endIndex;
        }
        return answerCount[0];
    }
}
