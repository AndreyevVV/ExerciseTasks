package LeetCode.Daily_Challenge.Medium.Check_if_Number_is_a_Sum_of_Powers_of_Three;

public class Solution {

    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2)
                return false;
            n /= 3;
        }
        return true;
    }
}
