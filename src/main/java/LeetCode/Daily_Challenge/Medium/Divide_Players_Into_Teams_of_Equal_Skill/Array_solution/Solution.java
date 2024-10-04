package LeetCode.Daily_Challenge.Medium.Divide_Players_Into_Teams_of_Equal_Skill.Array_solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int totalSkill = skill[0] + skill[skill.length - 1];
        long chemistry = 0;

        for (int i = 0, j = skill.length - 1; i < j; i++, j--) {
            if (skill[i] + skill[j] != totalSkill) return -1L;
            chemistry += (long) skill[i] * skill[j];
        }

        return chemistry;
    }
}
