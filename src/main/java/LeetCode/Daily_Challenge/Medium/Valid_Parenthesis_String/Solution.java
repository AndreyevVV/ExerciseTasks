package LeetCode.Daily_Challenge.Medium.Valid_Parenthesis_String;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().checkValidString("()"));
    }

    public boolean checkValidString(String s) {
        int low = 0, high = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                if (low > 0) low--;
                high--;
            } else {
                if (low > 0) low--;
                high++;
            }
            if (high < 0) return false;
        }
        return low == 0;
    }
}
