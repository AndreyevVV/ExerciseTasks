package LeetCode.Daily_Challenge.Medium.Minimum_Index_of_a_Valid_Split;

import java.util.List;

public class Solution {

    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();

        int candidate = -1, count = 0;
        for (int num : nums) {
            if (count == 0)
                candidate = num;
            count += (num == candidate) ? 1 : -1;
        }

        int totalCount = 0;
        for (int num : nums)
            if (num == candidate)
                totalCount++;

        if (totalCount * 2 <= n) return -1;

        int leftCount = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == candidate)
                leftCount++;
            int rightCount = totalCount - leftCount;
            if (leftCount * 2 > (i + 1) && rightCount * 2 > (n - i - 1))
                return i;
        }

        return -1;
    }
}
