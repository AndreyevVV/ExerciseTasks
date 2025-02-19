package LeetCode.Daily_Challenge.Medium.The_k_th_Lexicographical_String_of_All_Happy_Strings_of_Length_n;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution finder = new Solution();
        System.out.println(finder.getHappyString(1, 3)); // "c"
        System.out.println(finder.getHappyString(1, 4)); // ""
        System.out.println(finder.getHappyString(3, 9)); // "cab"
    }

    public String getHappyString(int n, int k) {
        List<String> happyStrings = new ArrayList<>();
        backtrack(n, new StringBuilder(), ' ', happyStrings);
        return k <= happyStrings.size() ? happyStrings.get(k - 1) : "";
    }

    private void backtrack(int n, StringBuilder sb, char lastChar, List<String> result) {
        if (sb.length() == n) {
            result.add(sb.toString());
            return;
        }
        for (char ch : new char[]{'a', 'b', 'c'}) {
            if (ch != lastChar) {
                sb.append(ch);
                backtrack(n, sb, ch, result);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
