package LeetCode.LeetCode_75.Binary_Search.Medium.Successful_Pairs_of_Spells_and_Potions;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution()
                .successfulPairs(new int[]{9, 39}, new int[]{35, 40, 22, 37, 29, 22}, 320L)));
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] answer = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            answer[i] = binarySearch(spells[i], potions, success);
        }
        return answer;
    }

    private int binarySearch(int spell, int[] potions, long success) {
        int l = 0, r = potions.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if ((long) potions[mid] * spell >= success) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return potions.length - l;
    }
}
