package LeetCode.Top_Interview_150.Stack.Medium.Simplify_Path;

import java.util.Stack;

public class Solution {

    public String simplifyPath(String path) {
        String[] components = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String component : components) {
            if (component.isEmpty() || component.equals(".")) continue;

            if (component.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else stack.push(component);
        }

        StringBuilder simplifiedPath = new StringBuilder("/");
        for (String dir : stack) {
            simplifiedPath.append(dir).append("/");
        }

        if (simplifiedPath.length() > 1)
            simplifiedPath.setLength(simplifiedPath.length() - 1);

        return simplifiedPath.toString();
    }
}
