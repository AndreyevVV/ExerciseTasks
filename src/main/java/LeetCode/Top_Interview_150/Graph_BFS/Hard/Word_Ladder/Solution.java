package LeetCode.Top_Interview_150.Graph_BFS.Hard.Word_Ladder;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().ladderLength("hit", "cog"
                , new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"))));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int transformations = 1;

        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r'
                , 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();
                char[] currChars = currWord.toCharArray();

                for (int j = 0; j < currChars.length; j++) {
                    char origChar = currChars[j];

                    for (char character : alphabet) {
                        if (character != origChar) {
                            currChars[j] = character;
                            String trasformedWord = new String(currChars);

                            if (trasformedWord.equals(endWord)) return ++transformations;

                            if (set.contains(trasformedWord)) {
                                set.remove(trasformedWord);
                                queue.offer(trasformedWord);
                            }

                            currChars[j] = origChar;
                        }
                    }
                }

            }
            transformations++;
        }
        return 0;
    }
}
