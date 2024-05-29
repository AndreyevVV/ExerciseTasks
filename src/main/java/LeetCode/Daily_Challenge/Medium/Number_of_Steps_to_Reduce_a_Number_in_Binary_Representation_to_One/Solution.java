package LeetCode.Daily_Challenge.Medium.Number_of_Steps_to_Reduce_a_Number_in_Binary_Representation_to_One;

public class Solution {

    public int numSteps(String s) {
        int steps = 0;

        while (!s.equals("1")) {
            int len = s.length();
            if (s.charAt(len - 1) == '0')
                s = s.substring(0, len - 1);
            else
                s = addOne(s);
            steps++;
        }

        return steps;
    }

    private String addOne(String s) {
        StringBuilder sb = new StringBuilder();
        int carry = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            int sum = (s.charAt(i) - '0') + carry;
            if (sum == 2) {
                sb.append('0');
                carry = 1;
            } else {
                sb.append(sum);
                carry = 0;
            }
        }

        if (carry == 1)
            sb.append('1');

        return sb.reverse().toString();
    }
}
