package LeetCode.Daily_Challenge.Medium.Design_a_Number_Container_System;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution {
    class NumberContainers {
        private Map<Integer, Integer> indexToNumber;
        private Map<Integer, TreeSet<Integer>> numberToIndices;

        public NumberContainers() {
            indexToNumber = new HashMap<>();
            numberToIndices = new HashMap<>();
        }

        public void change(int index, int number) {
            if (indexToNumber.containsKey(index)) {
                int oldNumber = indexToNumber.get(index);
                if (oldNumber != number) {
                    numberToIndices.get(oldNumber).remove(index);
                    if (numberToIndices.get(oldNumber).isEmpty())
                        numberToIndices.remove(oldNumber);
                }
            }

            indexToNumber.put(index, number);
            numberToIndices.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
        }

        public int find(int number) {
            return numberToIndices.containsKey(number) ? numberToIndices.get(number).first() : -1;
        }
    }
}
