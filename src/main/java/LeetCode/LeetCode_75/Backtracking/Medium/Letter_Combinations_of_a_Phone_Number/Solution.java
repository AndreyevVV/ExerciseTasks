package LeetCode.LeetCode_75.Backtracking.Medium.Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private Map<Character, String> phoneMapping = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        phoneMapping.put('2', "abc");
        phoneMapping.put('3', "def");
        phoneMapping.put('4', "ghi");
        phoneMapping.put('5', "jkl");
        phoneMapping.put('6', "mno");
        phoneMapping.put('7', "pqrs");
        phoneMapping.put('8', "tuv");
        phoneMapping.put('9', "wxyz");

        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }

        backtrack(0, digits, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int index, String digits, StringBuilder path, List<String> result) {
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        String letters = phoneMapping.get(digits.charAt(index));
        for (char letter : letters.toCharArray()) {
            path.append(letter);
            backtrack(index + 1, digits, path, result);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
