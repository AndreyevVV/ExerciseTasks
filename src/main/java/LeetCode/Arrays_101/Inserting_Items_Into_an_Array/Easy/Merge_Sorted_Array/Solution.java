package LeetCode.Arrays_101.Inserting_Items_Into_an_Array.Easy.Merge_Sorted_Array;

public class Solution {
    public static void main(String[] args) {
        new Solution().merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1Pointer = m - 1, nums2Pointer = n - 1, resultPointer = m + n - 1;

        while (nums2Pointer >= 0) {
            if (nums1[nums1Pointer] >= nums2[nums2Pointer]) {
                nums1[resultPointer--] = nums1[nums1Pointer--];
            } else {
                nums1[resultPointer--] = nums1[nums2Pointer--];
            }
        }
    }
}
