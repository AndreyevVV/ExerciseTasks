package LeetCode.Problems.Easy.A_Number_After_a_Double_Reversal;

public class Solution {
    public boolean isSameAfterReversals(int num) {
        if (num == 0) return true;
        else return num % 10 != 0;
    }
}
