package LeetCode.Daily_Challenge.Easy.Make_The_String_Great;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().makeGood("leEeetcode"));
    }

    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (sb.length() > 0 && Math.abs(sb.charAt(sb.length() - 1) - ch) == 32)
                sb.deleteCharAt(sb.length() - 1);
            else
                sb.append(ch);
        }
        return sb.toString();
    }
}
