package LeetCode.LeetCode_75_Level_2.Day_16_Design.Medium.Implement_Trie_Prefix_Tree;

//import LeetCode.LeetCode_75_Level_2.Day_16_Design.Medium.Implement_Trie_Prefix_Tree.HashMap_for_prefix_solution.Trie;
import LeetCode.LeetCode_75_Level_2.Day_16_Design.Medium.Implement_Trie_Prefix_Tree.Massif_for_prefix_slution.Trie;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple")); // Вывод: true
        System.out.println(trie.search("app")); // Вывод: false
        System.out.println(trie.startsWith("app")); // Вывод: true

        trie.insert("orange");
        System.out.println(trie.search("orange")); // Вывод: true
        System.out.println(trie.search("banana")); // Вывод: false
        System.out.println(trie.startsWith("ban")); // Вывод: false
    }
}
