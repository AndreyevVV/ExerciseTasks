package LeetCode.Daily_Challenge.Hard.Kth_Smallest_Product_of_Two_Sorted_Arrays;

public class Solution {

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = -10_000_000_000L;
        long right = 10_000_000_000L;

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (countLessOrEqual(nums1, nums2, mid) < k)
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }

    private long countLessOrEqual(int[] nums1, int[] nums2, long target) {
        long count = 0;

        for (int a : nums1) {
            if (a == 0) {
                if (target >= 0) count += nums2.length;
                continue;
            }

            int low = 0, high = nums2.length;

            while (low < high) {
                int mid = low + (high - low) / 2;
                long product = (long) a * nums2[mid];

                if (product <= target)
                    if (a > 0)
                        low = mid + 1;
                    else
                        high = mid;
                else if (a > 0)
                    high = mid;
                else
                    low = mid + 1;
            }

            count += (a > 0) ? low : nums2.length - low;
        }

        return count;
    }
}
