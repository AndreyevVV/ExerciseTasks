package LeetCode.Daily_Challenge.Easy.Check_If_N_and_Its_Double_Exist;

import java.util.HashSet;

public class Solution {

    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (set.contains(2 * num) || (num % 2 == 0 && set.contains(num / 2)))
                return true;
            set.add(num);
        }

        return false;
    }
}
