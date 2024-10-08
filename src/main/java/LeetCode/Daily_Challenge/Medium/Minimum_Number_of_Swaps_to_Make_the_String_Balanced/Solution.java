package LeetCode.Daily_Challenge.Medium.Minimum_Number_of_Swaps_to_Make_the_String_Balanced;

public class Solution {

    public int minSwaps(String s) {
        int oc = 0;
        int balance = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '[')
                oc++;
            else {
                if (oc > 0)
                    oc--;
                else
                    balance++;
            }
        }
        return (balance + 1) / 2;
    }
}
