package LeetCode.Daily_Challenge.Hard.Find_the_Maximum_Sum_of_Node_Values;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 1};
        int k1 = 3;
        int[][] edges1 = {{0, 1}, {0, 2}};
        System.out.println(maximumValueSum(nums1, k1, edges1)); // Output: 6

        int[] nums2 = {2, 3};
        int k2 = 7;
        int[][] edges2 = {{0, 1}};
        System.out.println(maximumValueSum(nums2, k2, edges2)); // Output: 9

        int[] nums3 = {7, 7, 7, 7, 7, 7};
        int k3 = 3;
        int[][] edges3 = {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}};
        System.out.println(maximumValueSum(nums3, k3, edges3)); // Output: 42
    }

    public static long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum = 0;
        int n = nums.length;
        List<Integer> diff = new ArrayList<>();

        for (int num : nums) {
            sum += num;
            diff.add((num ^ k) - num);
        }

        diff.sort(Collections.reverseOrder());

        for (int i = 0; i < n - 1; i += 2) {
            int delta = diff.get(i) + diff.get(i + 1);
            if (delta > 0)
                sum += delta;
            else
                break;
        }

        return sum;
    }
}
