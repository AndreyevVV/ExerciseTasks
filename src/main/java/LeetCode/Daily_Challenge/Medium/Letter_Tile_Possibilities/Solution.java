package LeetCode.Daily_Challenge.Medium.Letter_Tile_Possibilities;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numTilePossibilities("AAB"));    // 8
        System.out.println(sol.numTilePossibilities("AAABBC")); // 188
        System.out.println(sol.numTilePossibilities("V"));      // 1
    }

    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : tiles.toCharArray())
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        return dfs(freqMap);
    }

    private int dfs(Map<Character, Integer> freqMap) {
        int count = 0;
        for (char c : freqMap.keySet()) {
            if (freqMap.get(c) > 0) {
                count++;
                freqMap.put(c, freqMap.get(c) - 1);
                count += dfs(freqMap);
                freqMap.put(c, freqMap.get(c) + 1);
            }
        }
        return count;
    }
}
