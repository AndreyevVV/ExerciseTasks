package LeetCode.LeetCode_75_Level_1.Day_2_String.Easy.Isomorphic_Strings;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isIsomorphic("badc", "baba"));
    }

    public boolean isIsomorphic(String s, String t) {

        int sLength = s.length(), tLength = t.length();

        if (sLength != tLength) return false;

        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < sLength; i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (sToT.containsKey(sChar) && sToT.get(sChar) != tChar ||
                    tToS.containsKey(tChar) && tToS.get(tChar) != sChar) {
                return false;
            }

            sToT.put(sChar, tChar);
            tToS.put(tChar, sChar);
        }
        return true;
    }
}
