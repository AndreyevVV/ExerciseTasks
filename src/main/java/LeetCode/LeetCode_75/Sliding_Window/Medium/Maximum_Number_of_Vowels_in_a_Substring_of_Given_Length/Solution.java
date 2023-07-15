package LeetCode.LeetCode_75.Sliding_Window.Medium.Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxVowels("leetcode", 3));
    }

    public int maxVowels(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        Set<Character> vowelsSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        int vowelsVount = 0;
        for (int i = 0; i < k; i++) {
            vowelsVount += vowelsSet.contains(s.charAt(i)) ? 1 : 0;
        }

        int answer = vowelsVount;
        int leftBorder = 0, rightBorder = k - 1;

        while (rightBorder < s.length()) {
            vowelsVount += vowelsSet.contains(s.charAt(++rightBorder)) ? 1 : 0;
            vowelsVount -= vowelsSet.contains(s.charAt(leftBorder++)) ? 1 : 0;
            answer = Math.max(answer, vowelsVount);
            if (answer == k) return k;
        }
        return answer;
    }
}
