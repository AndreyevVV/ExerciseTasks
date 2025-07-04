package LeetCode.Daily_Challenge.Hard.Find_the_Kth_Character_in_String_Game_II;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public char kthCharacter(long k, int[] operations) {
        long length = 1;
        int shift = 0;

        List<Long> lengths = new ArrayList<>();
        for (int ignored : operations) {
            length *= 2;
            lengths.add(length);
            if (length >= k) break;
        }

        for (int i = lengths.size() - 1; i >= 0; i--) {
            long half = lengths.get(i) / 2;

            if (k > half) {
                k -= half;
                if (operations[i] == 1)
                    shift = (shift + 1) % 26;
            }
        }

        return (char) ('a' + shift);
    }
}
