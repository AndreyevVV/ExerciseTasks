package LeetCode.Daily_Challenge.Medium.Find_the_Student_that_Will_Replace_the_Chalk;

public class Solution {

    public int chalkReplacer(int[] chalk, int k) {
        long totalChalk = 0;
        for (int amount : chalk)
            totalChalk += amount;

        k %= totalChalk;

        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i])
                return i;
            k -= chalk[i];
        }

        return -1;
    }
}
