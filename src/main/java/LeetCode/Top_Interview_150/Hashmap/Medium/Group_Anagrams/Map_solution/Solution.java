package LeetCode.Top_Interview_150.Hashmap.Medium.Group_Anagrams.Map_solution;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if (anagramMap.containsKey(key)) {
                anagramMap.get(key).add(str);
            } else {
                List<String> group = new ArrayList<>();
                group.add(str);
                anagramMap.put(key, group);
            }
        }
        return new ArrayList<>(anagramMap.values());
    }
}
