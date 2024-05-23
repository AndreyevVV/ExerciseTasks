package LeetCode.Daily_Challenge.Medium.The_Number_of_Beautiful_Subsets.BackTracking_solution;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int count = 0;

    public int beautifulSubsets(int[] nums, int k) {
        countBeautifulSubsets(nums, k, 0, new ArrayList<>());
        return count - 1;
    }

    private void countBeautifulSubsets(int[] nums, int k, int index, List<Integer> currentSubset) {
        if (index >= nums.length) {
            count++;
            return;
        }

        countBeautifulSubsets(nums, k, index + 1, currentSubset);

        int currentElement = nums[index];
        boolean isBeautiful = true;
        for (int num : currentSubset) {
            if (Math.abs(num - currentElement) == k) {
                isBeautiful = false;
                break;
            }
        }

        if (isBeautiful) {
            currentSubset.add(currentElement);
            countBeautifulSubsets(nums, k, index + 1, currentSubset);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}
