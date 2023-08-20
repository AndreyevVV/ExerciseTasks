package LeetCode.LeetCode_75.Backtracking.Medium.Combination_Sum_III.Itertive_solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<State> stack = new Stack<>();
        stack.push(new State(k, n, 1, new ArrayList<>()));

        while (!stack.isEmpty()) {
            State state = stack.pop();
            int kVal = state.k;
            int targetVal = state.target;
            int startVal = state.start;
            List<Integer> currentVal = state.current;

            if (kVal == 0 && targetVal == 0) {
                result.add(currentVal);
            } else {
                for (int i = startVal; i <= 9; i++) {
                    if (i > targetVal) {
                        break;
                    }

                    List<Integer> newCurrent = new ArrayList<>(currentVal);
                    newCurrent.add(i);
                    stack.push(new State(kVal - 1, targetVal - i, i + 1, newCurrent));
                }
            }
        }
        return result;
    }

    private class State {
        int k;
        int target;
        int start;
        List<Integer> current;

        State(int k, int target, int start, List<Integer> current) {
            this.k = k;
            this.target = target;
            this.start = start;
            this.current = new ArrayList<>(current);
        }
    }
}
