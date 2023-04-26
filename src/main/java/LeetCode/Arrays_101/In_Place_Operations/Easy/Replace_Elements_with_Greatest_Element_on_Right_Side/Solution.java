package LeetCode.Arrays_101.In_Place_Operations.Easy.Replace_Elements_with_Greatest_Element_on_Right_Side;

public class Solution {

    public int[] replaceElements(int[] arr) {
        int left = 0;
        int right = 0;
        int arrLength = arr.length;

        if (arrLength == 1) {
            arr[arrLength - 1] = -1;
            return arr;
        }

        while (right < arrLength) {
            int maxElemFromRight = Integer.MIN_VALUE;

            for (int i = right; i < arrLength; i++) {
                if (arr[i] > maxElemFromRight) {
                    maxElemFromRight = arr[i];
                    right = i;
                }
            }
            for (int i = left; i < right; i++) {
                arr[i] = arr[right];
            }
            left = right;
            right = right + 1;
        }
        arr[arrLength - 1] = -1;
        return arr;
    }
}
