package LeetCode.Daily_Challenge.Medium.Divide_Players_Into_Teams_of_Equal_Skill.HashMap_solution;

import java.util.HashMap;

public class Solution {

    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int totalSkill = 0;
        HashMap<Integer, Integer> skillFrequency = new HashMap<>();

        for (int playerSkill : skill) {
            totalSkill += playerSkill;
            skillFrequency.put(playerSkill, skillFrequency.getOrDefault(playerSkill, 0) + 1);
        }

        if (totalSkill % (n / 2) != 0)
            return -1;

        int targetTeamSkill = totalSkill / (n / 2);
        long totalChemistry = 0;

        for (int playerSkill : skill) {
            int partnerSkill = targetTeamSkill - playerSkill;

            if (skillFrequency.getOrDefault(partnerSkill, 0) == 0)
                return -1;

            totalChemistry += (long) playerSkill * (long) partnerSkill;
            skillFrequency.put(partnerSkill, skillFrequency.get(partnerSkill) - 1);
        }

        return totalChemistry / 2;
    }
}
