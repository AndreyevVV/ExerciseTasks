package LeetCode.LeetCode_75.Array_String.Reverse_Vowels_of_a_String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseVowels("hello"));
    }

    public String reverseVowels(String s) {
        Set<Character> vowelsSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        StringBuilder answer = new StringBuilder(s);
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (!vowelsSet.contains(s.charAt(left))) left++;
            else if (!vowelsSet.contains(s.charAt(right))) right--;
            else {
                answer.setCharAt(left, s.charAt(right));
                answer.setCharAt(right++, s.charAt(left++));
            }
        }
        return answer.toString();
    }
}
