package LeetCode.Daily_Challenge.Hard.Sum_of_Prefix_Scores_of_Strings;

public class Solution {

    class TrieNode {
        TrieNode[] children;
        int count;

        public TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }
    }

    private TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (node.children[index] == null)
                node.children[index] = new TrieNode();

            node = node.children[index];
            node.count++;
        }
    }

    public int getPrefixScore(String word) {
        TrieNode node = root;
        int score = 0;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            node = node.children[index];
            score += node.count;
        }
        return score;
    }

    public int[] sumPrefixScores(String[] words) {
        for (String word : words)
            insert(word);

        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++)
            result[i] = getPrefixScore(words[i]);

        return result;
    }
}
