package LeetCode.LeetCode_75_Level_2.Day_2_String.Medium.Multiply_Strings;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().multiply("2", "3"));
    }

    public String multiply(String num1, String num2) {
        int num1Length = num1.length(), num2Length = num2.length();
        int[] indexes = new int[num1Length + num2Length];

        for (int i = num1Length - 1; i >= 0; i--) {
            for (int j = num2Length - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                int pos1 = i + j;
                int pos2 = i + j + 1;
                int sum = mul + indexes[pos2];

                indexes[pos1] += sum / 10;
                indexes[pos2] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indexes.length; i++) {
            if (!(sb.length() == 0 && indexes[i] == 0)) {
                sb.append(indexes[i]);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
