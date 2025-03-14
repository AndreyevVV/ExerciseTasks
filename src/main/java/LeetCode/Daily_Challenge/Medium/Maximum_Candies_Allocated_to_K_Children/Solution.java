package LeetCode.Daily_Challenge.Medium.Maximum_Candies_Allocated_to_K_Children;

public class Solution {

    public int maximumCandies(int[] candies, long k) {
        int left = 1, right = 0;
        for (int c : candies)
            right = Math.max(right, c);

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long count = 0;

            for (int c : candies)
                count += c / mid;

            if (count >= k)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return right;
    }
}
