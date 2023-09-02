package LeetCode.LeetCode_75.Trie.Medium.Search_Suggestions_System.Classic_PrefixTree_solution;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().suggestedProducts(
                new String[]{"apple", "approval", "banana"}, "test"));
    }

    private PrefixTreeNode root = new PrefixTreeNode();

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        for (String word : products) insert(word);
        return search(searchWord);
    }

    private List<List<String>> search(String searchWord) {
        List<List<String>> result = new ArrayList<>();
        PrefixTreeNode current;

        for (int i = 0; i < searchWord.length(); i++) {
            current = startsWith(searchWord.substring(0, i + 1));
            if (current != null) {
                List<String> list = new ArrayList<>();
                StringBuilder sb = new StringBuilder(searchWord.substring(0, i + 1));
                backtrack(list, current, sb);
                result.add(list);
            } else result.add(new ArrayList<>());
        }
        return result;
    }

    private PrefixTreeNode startsWith(String prefix) {
        PrefixTreeNode current = this.root;

        for (int i = 0; i < prefix.length(); i++) {
            PrefixTreeNode node = current.links.get(prefix.charAt(i));
            if (node == null) return null;
            current = node;
        }
        return current;
    }

    private void backtrack(List<String> list, PrefixTreeNode current, StringBuilder subWord) {
        if (list.size() == 3) return;
        if (current.isEnd) list.add(subWord.toString());

        for (Map.Entry<Character, PrefixTreeNode> entry : current.links.entrySet()) {
            char ch = entry.getKey();
            subWord.append(ch);
            PrefixTreeNode nextNode = entry.getValue();
            backtrack(list, nextNode, subWord);
            subWord.deleteCharAt(subWord.length() - 1);
        }
    }

    private void insert(String word) {
        PrefixTreeNode node = root;
        for (char character : word.toCharArray()) {
            if (!node.containsKey(character)) {
                node.put(character, new PrefixTreeNode());
            }
            node = node.get(character);
        }
        node.setEnd();
    }

    static class PrefixTreeNode {
        private Map<Character, PrefixTreeNode> links;
        private boolean isEnd;

        public PrefixTreeNode() {
            links = new TreeMap<>();
            isEnd = false;
        }

        public boolean containsKey(char ch) {
            return links.containsKey(ch);
        }

        public PrefixTreeNode get(char ch) {
            return links.get(ch);
        }

        public void put(char ch, PrefixTreeNode node) {
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
