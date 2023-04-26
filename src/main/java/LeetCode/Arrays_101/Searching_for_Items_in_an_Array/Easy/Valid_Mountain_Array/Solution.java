package LeetCode.Arrays_101.Searching_for_Items_in_an_Array.Easy.Valid_Mountain_Array;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().validMountainArray(new int[] {3,7,6,4,3,0,1,0}));
    }
    public boolean validMountainArray(int[] arr) {
        int length = arr.length;
        if (length < 3) return false;

        int left = 1;
        int right = length - 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                if (isMountainPeek(mid, arr)) {
                    System.out.println(arr[mid]);
                    return true;
                }
            }

            if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    private boolean isMountainPeek(int mid, int[] arr) {
        for (int i = 0; i < mid; i++) {
            if (arr[i] >= arr[i + 1]) return false;
        }

        for (int i = arr.length - 1; i > mid; i--) {
            if (arr[i] >= arr[i - 1]) return false;
        }
        return true;
    }
}
