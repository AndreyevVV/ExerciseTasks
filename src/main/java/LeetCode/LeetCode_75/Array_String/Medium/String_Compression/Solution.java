package LeetCode.LeetCode_75.Array_String.Medium.String_Compression;

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
                String str = String.valueOf(count);
                str.chars().forEach(character -> chars[answerCount[0]++] = (char) character);
            }

            startIndex = endIndex;
        }
        return answerCount[0];
    }
}
