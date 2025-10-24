package LeetCode.Daily_Challenge.Medium.Next_Greater_Numerically_Balanced_Number;

public class Solution {
 
    private static final List<Integer> balanced = new ArrayList<>();

    static {
        generate(new StringBuilder(), new boolean[10]);
        Collections.sort(balanced);
    }

    private static void generate(StringBuilder sb, boolean[] used) {
        if (sb.length() > 7) return;
        if (sb.length() > 0 && isBalanced(sb.toString()))
            balanced.add(Integer.parseInt(sb.toString()));
        for (int d = 1; d <= 7; d++) {
            if (count(sb, d) < d) {
                sb.append(d);
                generate(sb, used);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private static int count(CharSequence s, int digit) {
        int c = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) - '0' == digit) c++;
        return c;
    }

    private static boolean isBalanced(String s) {
        int[] freq = new int[10];
        for (char c : s.toCharArray()) freq[c - '0']++;
        for (int d = 1; d <= 9; d++)
            if (freq[d] > 0 && freq[d] != d) return false;
        return true;
    }

    public int nextBeautifulNumber(int n) {
        for (int x : balanced)
            if (x > n) return x;
        return -1;
    }
}
