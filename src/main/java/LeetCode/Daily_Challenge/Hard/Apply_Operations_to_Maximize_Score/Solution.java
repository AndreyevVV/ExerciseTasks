package LeetCode.Daily_Challenge.Hard.Apply_Operations_to_Maximize_Score;

import java.util.*;

public class Solution {

    private static final int MOD = 1_000_000_007;

    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size();
        int[][] elements = new int[n][3];

        for (int i = 0; i < n; i++)
            elements[i] = new int[]{i, countPrimeFactors(nums.get(i)), nums.get(i)};

        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int[] element : elements) {
            int index = element[0], primeScore = element[1];
            while (!stack.isEmpty() && elements[stack.peek()][1] < primeScore)
                stack.pop();
            if (!stack.isEmpty())
                left[index] = stack.peek();
            stack.push(index);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            int primeScore = elements[i][1];
            while (!stack.isEmpty() && elements[stack.peek()][1] <= primeScore)
                stack.pop();
            if (!stack.isEmpty())
                right[i] = stack.peek();
            stack.push(i);
        }

        Arrays.sort(elements, (a, b) -> Integer.compare(b[2], a[2]));

        long result = 1;

        for (int[] element : elements) {
            int index = element[0], value = element[2];
            int leftBound = left[index], rightBound = right[index];
            long count = (long) (index - leftBound) * (rightBound - index);

            if (count <= k) {
                result = result * modPow(value, count) % MOD;
                k -= count;
            } else {
                result = result * modPow(value, k) % MOD;
                break;
            }
        }

        return (int) result;
    }

    private int countPrimeFactors(int num) {
        int factor = 2;
        Set<Integer> primes = new HashSet<>();
        while (factor * factor <= num) {
            while (num % factor == 0) {
                primes.add(factor);
                num /= factor;
            }
            factor++;
        }
        if (num > 1)
            primes.add(num);
        return primes.size();
    }

    private long modPow(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1)
                result = result * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return result;
    }
}
