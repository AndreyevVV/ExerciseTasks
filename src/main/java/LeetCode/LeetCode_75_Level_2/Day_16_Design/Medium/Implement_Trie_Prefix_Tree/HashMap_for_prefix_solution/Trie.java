package LeetCode.LeetCode_75_Level_2.Day_16_Design.Medium.Implement_Trie_Prefix_Tree.HashMap_for_prefix_solution;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.containsKey(ch)) {
                node = node.get(ch);
            } else {
                return null;
            }
        }
        return node;
    }

    static class TrieNode {
        private Map<Character, TrieNode> links;
        private boolean isEnd;

        public TrieNode() {
            links = new HashMap<>();
            isEnd = false;
        }

        public boolean containsKey(char ch) {
            return links.containsKey(ch);
        }

        public TrieNode get(char ch) {
            return links.get(ch);
        }

        public void put(char ch, TrieNode node) {
            links.put(ch, node);
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }
}
