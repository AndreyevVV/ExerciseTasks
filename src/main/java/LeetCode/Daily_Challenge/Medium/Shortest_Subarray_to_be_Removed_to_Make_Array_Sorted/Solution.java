package LeetCode.Daily_Challenge.Medium.Shortest_Subarray_to_be_Removed_to_Make_Array_Sorted;

public class Solution {

    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        int left = 0;
        while (left < n - 1 && arr[left] <= arr[left + 1])
            left++;

        if (left == n - 1)
            return 0;

        int right = n - 1;

        while (right > 0 && arr[right - 1] <= arr[right])
            right--;

        int result = Math.min(n - left - 1, right);

        // Step 4: Merge prefix and suffix
        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                result = Math.min(result, j - i - 1);
                i++;
            } else
                j++;
        }

        return result;
    }
}
