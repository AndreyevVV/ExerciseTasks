package LeetCode.Daily_Challenge.Medium.Number_of_Laser_Beams_in_a_Bank;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numberOfBeams(new String[]{"011001", "000000", "010100", "001000"}));
    }

    public int numberOfBeams(String[] bank) {
        if (bank == null || bank.length <= 1) return 0;
        int beams = 0, r = 0;

        for (String s : bank) {
            int devices = (int) s.chars().filter(ch -> ch == '1').count();

            if (devices > 0) {
                beams += r * devices;
                r = devices;
            }
        }
        return beams;
    }
}
