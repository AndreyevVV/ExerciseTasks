package LeetCode.Daily_Challenge.Easy.Count_Symmetric_Integers;

public class Solution {

    public int countSymmetricIntegers(int low, int high) {
        int count = 0;

        for (int i = low; i <= high; i++) {
            String num = String.valueOf(i);
            int len = num.length();

            if (len % 2 != 0) continue;

            int half = len / 2;
            int sumLeft = 0, sumRight = 0;

            for (int j = 0; j < half; j++) {
                sumLeft += num.charAt(j) - '0';
                sumRight += num.charAt(j + half) - '0';
            }

            if (sumLeft == sumRight) count++;
        }

        return count;
    }
}
