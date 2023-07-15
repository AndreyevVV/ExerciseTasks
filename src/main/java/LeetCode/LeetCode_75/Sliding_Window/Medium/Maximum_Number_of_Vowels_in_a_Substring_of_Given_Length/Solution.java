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

        int vowelsCount = 0;
        for (int i = 0; i < k; i++) {
            vowelsCount += vowelsSet.contains((s.charAt(i))) ? 1 : 0;
        }
        int answer = vowelsCount;
        for (int i = k; i < s.length(); i++) {
            vowelsCount += vowelsSet.contains((s.charAt(i))) ? 1 : 0;
            vowelsCount -= vowelsSet.contains((s.charAt(i - k))) ? 1 : 0;

            answer = Math.max(answer, vowelsCount);
            if (answer == k) return k;
        }
        return answer;
    }
}
