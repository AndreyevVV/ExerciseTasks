package LeetCode.Daily_Challenge.Medium.Check_if_a_Parentheses_String_Can_Be_Valid;

public class Solution {

    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) return false;

        int openBalance = 0;
        int flexibleSlots = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (locked.charAt(i) == '0')
                flexibleSlots++;
            else if (c == '(')
                openBalance++;
            else
                openBalance--;

            if (openBalance < 0) {
                if (flexibleSlots > 0) {
                    flexibleSlots--;
                    openBalance++;
                } else
                    return false;
            }
        }

        int closeBalance = 0;
        flexibleSlots = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (locked.charAt(i) == '0')
                flexibleSlots++;
            else if (c == ')')
                closeBalance++;
            else
                closeBalance--;


            if (closeBalance < 0) {
                if (flexibleSlots > 0) {
                    flexibleSlots--;
                    closeBalance++;
                } else
                    return false;
            }
        }

        return true;
    }
}
