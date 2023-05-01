package LeetCode.LeetCode_75_Level_2.Day_1_Implementation_Simulation.Day_2_String.Easy.Happy_Number;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean isHappy(int n) {
        int answer;
        Set<Integer> set = new HashSet<>();

        do {
            answer = 0;

            while (n != 0) {
                answer += (n % 10) * (n % 10);
                n /= 10;
            }
            if (set.contains(answer)) break;

            n = answer;
            set.add(answer);
        } while (answer != 1);
        return answer == 1;
    }
}
