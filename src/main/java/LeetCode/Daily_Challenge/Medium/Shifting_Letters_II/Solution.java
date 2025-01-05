package LeetCode.Daily_Challenge.Medium.Shifting_Letters_II;

public class Solution {

    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n + 1];

        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2] == 1 ? 1 : -1;

            diff[start] += direction;
            diff[end + 1] -= direction;
        }

        int shift = 0;
        char[] result = s.toCharArray();

        for (int i = 0; i < n; i++) {
            shift += diff[i];
            result[i] = shiftChar(result[i], shift);
        }

        return new String(result);
    }

    private char shiftChar(char c, int shift) {
        int newPos = (c - 'a' + shift) % 26;
        if (newPos < 0)
            newPos += 26;
        return (char) ('a' + newPos);
    }
}
