package LeetCode.Daily_Challenge.Easy.Largest_3_Same_Digit_Number_in_String;

public class Solution {

    public String largestGoodInteger(String num) {
        String max = "";

        for (int i = 0; i <= num.length() - 3; i++) {
            char c = num.charAt(i);
            if (c == num.charAt(i + 1) && c == num.charAt(i + 2)) {
                String triple = num.substring(i, i + 3);
                if (max.isEmpty() || triple.compareTo(max) > 0)
                    max = triple;
            }
        }
        return max;
    }
}
