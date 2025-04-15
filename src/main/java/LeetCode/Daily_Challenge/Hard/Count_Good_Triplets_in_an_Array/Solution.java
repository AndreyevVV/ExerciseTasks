package LeetCode.Daily_Challenge.Hard.Count_Good_Triplets_in_an_Array;

public class Solution {

    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;

        int[] pos = new int[n];
        for (int i = 0; i < n; i++)
            pos[nums1[i]] = i;

        int[] mapped = new int[n];
        for (int i = 0; i < n; i++)
            mapped[i] = pos[nums2[i]];

        long[] countLess = new long[n];
        FenwickTree bit1 = new FenwickTree(n);
        for (int i = 0; i < n; i++) {
            countLess[i] = bit1.query(mapped[i] - 1);
            bit1.update(mapped[i], 1);
        }

        long[] countGreater = new long[n];
        FenwickTree bit2 = new FenwickTree(n);
        for (int i = n - 1; i >= 0; i--) {
            countGreater[i] = bit2.query(n - 1) - bit2.query(mapped[i]);
            bit2.update(mapped[i], 1);
        }

        long result = 0;
        for (int i = 0; i < n; i++)
            result += countLess[i] * countGreater[i];

        return result;
    }

    static class FenwickTree {
        long[] tree;
        int n;

        FenwickTree(int size) {
            this.n = size;
            this.tree = new long[n + 1];
        }

        void update(int i, long delta) {
            i++;
            while (i <= n) {
                tree[i] += delta;
                i += i & -i;
            }
        }

        long query(int i) {
            i++;
            long sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= i & -i;
            }
            return sum;
        }
    }
}
