package LeetCode.Arrays_101.Searching_for_Items_in_an_Array.Easy.Check_If_N_and_Its_Double_Exist;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().checkIfExist(new int[] {10,2,5,3}));
    }
    public boolean checkIfExist(int[] arr) {
        if (arr == null || arr.length < 2) return false;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
           int left = 0;
           int right = arr.length - 1;

           while (left <= right) {
               int mid = left + (right - left) / 2;

               int target = 2 * arr[i];

               if (arr[mid] == target && mid != i) return true;

               if (target < arr[mid]) right = mid - 1;
               else left = mid + 1;
           }
        }
        return false;
    }
}
