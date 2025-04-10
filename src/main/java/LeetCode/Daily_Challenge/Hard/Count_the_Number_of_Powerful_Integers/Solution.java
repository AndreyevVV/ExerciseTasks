package LeetCode.Daily_Challenge.Hard.Count_the_Number_of_Powerful_Integers;

public class Solution {

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        return calculate(Long.toString(finish), s, limit) - calculate(Long.toString(start - 1), s, limit);
    }

    private long calculate(String x, String s, int limit) {
        if (x.length() < s.length())
            return 0;

        if (x.length() == s.length())
            return x.compareTo(s) >= 0 ? 1 : 0;

        String suffix = x.substring(x.length() - s.length());
        long count = 0;
        int preLen = x.length() - s.length();

        for (int i = 0; i < preLen; i++) {
            int digit = x.charAt(i) - '0';

            if (limit < digit) {
                count += (long) Math.pow(limit + 1, preLen - i);
                return count;
            }

            count += (long) digit * (long) Math.pow(limit + 1, preLen - 1 - i);
        }

        if (suffix.compareTo(s) >= 0)
            count++;

        return count;
    }
}
