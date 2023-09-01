package LeetCode.LeetCode_75.Trie.Medium.Search_Suggestions_System.PriorityQueue_solution;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        PriorityQueue<String> queue = new PriorityQueue<>(3);
        List<List<String>> answer = new ArrayList<>();

        for (int i = 1; i <= searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i);

            for (String s : products) if (s.startsWith(prefix)) queue.offer(s);

            List<String> innerList = new ArrayList<>();
            for (int j = 0; j < 3; j++) if (queue.peek() != null) innerList.add(queue.poll());

            queue.clear();
            answer.add(innerList);
        }
        return answer;
    }
}
