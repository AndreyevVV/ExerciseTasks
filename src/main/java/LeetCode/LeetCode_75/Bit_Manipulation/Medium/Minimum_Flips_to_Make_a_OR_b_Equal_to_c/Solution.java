package LeetCode.LeetCode_75.Bit_Manipulation.Medium.Minimum_Flips_to_Make_a_OR_b_Equal_to_c;

public class Solution {

    public int minFlips(int a, int b, int c) {
        int answer = 0;

        while (a > 0 || b > 0 || c > 0) {
            int difa = a & 1,
                difb = b & 1,
                difc = c & 1;
            if ((difa | difb) == difc) {
                a >>= 1; b >>= 1; c >>= 1;
            } else if (difc == 0) {
                if (difa == 1 && difb == 1){
                    answer += 2;
                    a >>= 1; b >>= 1; c >>= 1;
                }
                else {
                    answer++;
                    a >>= 1; b >>= 1; c >>= 1;
                }
            } else {
                answer++;
                a >>= 1; b >>= 1; c >>= 1;
            }
        }
        return answer;
    }
}
