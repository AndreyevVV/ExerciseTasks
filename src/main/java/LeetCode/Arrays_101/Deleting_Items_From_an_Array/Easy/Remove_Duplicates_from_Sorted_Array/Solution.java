package LeetCode.Arrays_101.Deleting_Items_From_an_Array.Easy.Remove_Duplicates_from_Sorted_Array;

public class Solution {
//    public static void main(String[] args) {
//        int[] nums = [...]; // Input array
//        int[] expectedNums = [...]; // The expected answer with correct length
//
//        int k = new Solution().removeDuplicates(nums); // Calls your implementation
//
//        System.out.println(k);
//        System.out.println(Arrays.toString(nums));
//
//        assert k == expectedNums.length;
//        for (int i = 0; i < k; i++) {
//            assert nums[i] == expectedNums[i];
//        }
//    }

    public int removeDuplicates(int[] nums) {
        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[count]) {
                nums[count++ + 1] = nums[i];
            }
        }
        return ++count;
    }
}
