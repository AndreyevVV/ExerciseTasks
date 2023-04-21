package LeetCode.Arrays_101.Inserting_Items_Into_an_Array.Easy.Duplicate_Zeros;

public class Solution {

    public void duplicateZeros(int[] arr) {
        int l = 0, r = l;

        while (l < arr.length) {
            if (arr[l] == 0) {
                r = l + 1;
                while (r < arr.length && arr[r] == 0) r++;
                int zeroCount = r - l;

                for (int i = arr.length - 1; i >= r; i--) {
                    arr[i] = arr[i - zeroCount];
                }
                for (int i = r; i < zeroCount; i++) {
                    arr[i] = 0;
                }
                l = l - 1 + zeroCount * 2;
            }
            l++;
        }
    }
}
