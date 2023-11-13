package LeetCode.Top_Interview_150.Math.Easy.Palindrome_Number.Array_solution;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(1));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        List<Integer> list = new ArrayList<>();

        while (x >= 1) {
            list.add(x % 10);
            x /= 10;
        }

        Integer[] numPlaces = list.toArray(Integer[]::new);
        int left = 0, right = numPlaces.length - 1;

        while (left < right)
            if (numPlaces[left++] != numPlaces[right--]) return false;

        return true;
    }
}
