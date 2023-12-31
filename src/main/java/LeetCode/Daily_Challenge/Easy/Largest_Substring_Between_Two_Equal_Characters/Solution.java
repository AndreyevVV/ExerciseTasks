package LeetCode.Daily_Challenge.Easy.Largest_Substring_Between_Two_Equal_Characters;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxLengthBetweenEqualCharacters("abca"));
    }

    public int maxLengthBetweenEqualCharacters(String s) {
        int maxLength = -1;
        int[] firstIndex = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (firstIndex[currentChar - 'a'] == 0) {
                firstIndex[currentChar - 'a'] = i + 1;
            } else {
                int length = i - firstIndex[currentChar - 'a'];
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }
}
