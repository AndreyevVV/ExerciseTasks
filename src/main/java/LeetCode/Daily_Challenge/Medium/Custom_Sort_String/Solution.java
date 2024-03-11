package LeetCode.Daily_Challenge.Medium.Custom_Sort_String;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().customSortString("cba", "abcd"));
    }

    public String customSortString(String order, String s) {
        Map<Character, Integer> map = order.chars().mapToObj(e -> (char) e).collect(Collectors
                .toMap(Function.identity(), order::indexOf, (e1, e2) -> e1, HashMap::new));

        Queue<Entry> queue = new PriorityQueue<>(Comparator.comparing(Entry::getValue));

        for (char c : s.toCharArray()) {
            Entry entry = new Entry(c, map.getOrDefault(c, 27));
            queue.add(entry);
        }

        StringBuilder str = new StringBuilder();

        while (!queue.isEmpty())
            str.append(queue.poll().getCharacter());

        return str.toString();
    }

    public class Entry {
        char character;
        Integer value;

        public Entry(char character, int value) {
            this.character = character;
            this.value = value;
        }

        public char getCharacter() {
            return character;
        }

        public void setCharacter(char character) {
            this.character = character;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
