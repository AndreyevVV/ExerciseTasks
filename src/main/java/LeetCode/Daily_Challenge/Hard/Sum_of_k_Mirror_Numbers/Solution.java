package LeetCode.Daily_Challenge.Hard.Sum_of_k_Mirror_Numbers;

public class Solution {

    public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;
        int len = 1;

        while (count < n) {
            for (int half = (int)Math.pow(10, (len - 1) / 2);
                 half < (int)Math.pow(10, (len + 1) / 2) && count < n;
                 half++) {

                String firstHalf = Integer.toString(half);
                String full = len % 2 == 0 ?
                        firstHalf + new StringBuilder(firstHalf).reverse() :
                        firstHalf + new StringBuilder(firstHalf.substring(0, firstHalf.length() - 1)).reverse();

                long num = Long.parseLong(full);
                if (isPalindrome(toBaseK(num, k))) {
                    sum += num;
                    count++;
                }
            }
            len++;
        }

        return sum;
    }

    private String toBaseK(long num, int k) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % k);
            num /= k;
        }
        return sb.reverse().toString();
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r)
            if (s.charAt(l++) != s.charAt(r--)) return false;
        return true;
    }
}
