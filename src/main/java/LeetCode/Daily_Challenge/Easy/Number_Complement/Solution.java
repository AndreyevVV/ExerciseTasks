package LeetCode.Daily_Challenge.Easy.Number_Complement;

public class Solution {

    public int findComplement(int num) {
        int mask = 0;
        int temp = num;

        while (temp > 0) {
            mask = (mask << 1) | 1;
            temp >>= 1;
        }

        return num ^ mask;
    }
}
