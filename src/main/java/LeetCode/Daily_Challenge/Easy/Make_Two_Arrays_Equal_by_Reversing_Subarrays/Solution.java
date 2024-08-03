package LeetCode.Daily_Challenge.Easy.Make_Two_Arrays_Equal_by_Reversing_Subarrays;

public class Solution {

    public boolean canBeEqual(int[] target, int[] arr) {
        int[] elemFreq = new int[1001];

        for (int i = 0; i < target.length; i++) {
            elemFreq[target[i]]++;
            elemFreq[arr[i]]--;
        }

        for (int elem : elemFreq)
            if (elem != 0) return false;

        return true;
    }
}
