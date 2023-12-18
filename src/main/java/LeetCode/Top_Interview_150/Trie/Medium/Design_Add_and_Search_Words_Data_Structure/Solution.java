package LeetCode.Top_Interview_150.Trie.Medium.Design_Add_and_Search_Words_Data_Structure;

public class Solution {
    class WordDictionary {
        TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            return searchHelper(word, root, 0);
        }

        private boolean searchHelper(String word, TrieNode node, int index) {
            if (index == word.length())
                return node.isEnd;

            char c = word.charAt(index);
            if (c == '.') {
                for (TrieNode child : node.children)
                    if (child != null && searchHelper(word, child, index + 1))
                        return true;
                return false;
            } else {
                int charIndex = c - 'a';
                if (node.children[charIndex] == null)
                    return false;
                return searchHelper(word, node.children[charIndex], index + 1);
            }
        }

        class TrieNode {
            TrieNode[] children;
            boolean isEnd;

            public TrieNode() {
                children = new TrieNode[26];
                isEnd = false;
            }
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
