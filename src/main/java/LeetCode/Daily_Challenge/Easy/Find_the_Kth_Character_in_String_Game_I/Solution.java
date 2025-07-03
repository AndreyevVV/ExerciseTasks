package LeetCode.Daily_Challenge.Easy.Find_the_Kth_Character_in_String_Game_I;

public class Solution {

    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder("a");

        while (sb.length() < k) {
            int len = sb.length();
            StringBuilder next = new StringBuilder(len);
            for (int i = 0; i < len; i++) {
                char c = sb.charAt(i);
                char nextChar = (char) ((c - 'a' + 1) % 26 + 'a');
                next.append(nextChar);
            }
            sb.append(next);
        }

        return sb.charAt(k - 1);
    }
}
