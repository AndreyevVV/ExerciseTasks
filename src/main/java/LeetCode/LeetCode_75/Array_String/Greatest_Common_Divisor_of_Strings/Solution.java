package LeetCode.LeetCode_75.Array_String.Greatest_Common_Divisor_of_Strings;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().gcdOfStrings("ABCABC", "ABC"));
    }

    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";

        int pos = reduceStr(str1.length(), str2.length());
        return str1.substring(0, pos);
    }

    private int reduceStr(int lengthStr1, int lengthStr2) {
        if (lengthStr2 == 0) return lengthStr1;
        return reduceStr(lengthStr2, lengthStr1 % lengthStr2);
    }
}
