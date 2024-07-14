package LeetCode.Daily_Challenge.Hard.Number_of_Atoms;

import java.util.*;

public class Solution {

    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());
        int n = formula.length();
        for (int i = 0; i < n; ) {
            char ch = formula.charAt(i);
            if (ch == '(') {
                stack.push(new HashMap<>());
                i++;
            } else if (ch == ')') {
                Map<String, Integer> top = stack.pop();
                i++;
                int start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                int multiplicity = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                Map<String, Integer> peek = stack.peek();
                for (String key : top.keySet()) {
                    peek.put(key, peek.getOrDefault(key, 0) + top.get(key) * multiplicity);
                }
            } else {
                int start = i;
                i++; // move past the first character of the atom
                while (i < n && Character.isLowerCase(formula.charAt(i))) i++; // handle lowercase letters
                String name = formula.substring(start, i);
                start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                int multiplicity = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                Map<String, Integer> peek = stack.peek();
                peek.put(name, peek.getOrDefault(name, 0) + multiplicity);
            }
        }

        Map<String, Integer> result = stack.pop();
        StringBuilder sb = new StringBuilder();
        List<String> keys = new ArrayList<>(result.keySet());
        Collections.sort(keys);
        for (String key : keys) {
            sb.append(key);
            int count = result.get(key);
            if (count > 1) sb.append(count);
        }
        return sb.toString();
    }
}
