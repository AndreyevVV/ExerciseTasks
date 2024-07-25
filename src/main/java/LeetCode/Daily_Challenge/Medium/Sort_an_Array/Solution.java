package LeetCode.Daily_Challenge.Medium.Sort_an_Array;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {5, 2, 3, 1};
        int[] sorted1 = solution.sortArray(nums1);
        System.out.println(java.util.Arrays.toString(sorted1)); // [1, 2, 3, 5]

        int[] nums2 = {5, 1, 1, 2, 0, 0};
        int[] sorted2 = solution.sortArray(nums2);
        System.out.println(java.util.Arrays.toString(sorted2)); // [0, 0, 1, 1, 2, 5]
    }

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1)
            return nums;

        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = nums[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = nums[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                nums[k] = L[i];
                i++;
            } else {
                nums[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            nums[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            nums[k] = R[j];
            j++;
            k++;
        }
    }
}
