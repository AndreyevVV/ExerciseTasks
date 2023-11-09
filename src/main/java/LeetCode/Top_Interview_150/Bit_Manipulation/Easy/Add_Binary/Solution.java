package LeetCode.Top_Interview_150.Bit_Manipulation.Easy.Add_Binary;

public class Solution {

    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;

        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int bitA = (i >= 0) ? Character.getNumericValue(a.charAt(i--)) : 0;
            int bitB = (j >= 0) ? Character.getNumericValue(b.charAt(j--)) : 0;

            int sum = bitA + bitB + carry;
            result.insert(0, sum % 2);
            carry = sum / 2;
        }
        return result.toString();
    }
}
