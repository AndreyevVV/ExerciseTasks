package LeetCode.Top_Interview_150.Hashmap.Medium.Group_Anagrams;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
    private final LeetCode.Top_Interview_150.Hashmap.Easy.Valid_Anagram.Array_solution.Solution isAnagram
            = new LeetCode.Top_Interview_150.Hashmap.Easy.Valid_Anagram.Array_solution.Solution();
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        Set<Integer> inds = new HashSet<>();

        for (int i = 0; i < strs.length; i++) {
            if (inds.contains(i)) continue;
            List<String> temp = new ArrayList<>();
            temp.add(strs[i]);
            inds.add(i);
            for (int j = i + 1; j < strs.length; j++) {
                if (isAnagram.isAnagram(strs[i], strs[j])) {
                    temp.add(strs[j]);
                    inds.add(j);
                }
            }
            answer.add(temp);
        }
        return answer;
    }
}
