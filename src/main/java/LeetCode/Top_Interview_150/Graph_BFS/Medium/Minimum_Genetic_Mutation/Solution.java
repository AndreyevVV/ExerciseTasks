package LeetCode.Top_Interview_150.Graph_BFS.Medium.Minimum_Genetic_Mutation;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minMutation("AACCGGTT", "AAACGGTA"
                , new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(endGene)) return -1;

        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);

        int mutations = 0;

        char[] nitrogenousBases = {'A', 'C', 'T', 'G'};

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                char[] currChars = curr.toCharArray();

                for (int j = 0; j < currChars.length; j++) {
                    char origChar = currChars[j];

                    for (char character : nitrogenousBases) {
                        if (character != origChar) {
                            currChars[j] = character;
                            String mutation = new String(currChars);

                            if (mutation.equals(endGene)) return ++mutations;

                            if (set.contains(mutation)) {
                                set.remove(mutation);
                                queue.offer(mutation);
                            }

                            currChars[j] = origChar;
                        }
                    }
                }
            }
            mutations++;
        }
        return -1;
    }
}
