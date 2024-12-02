package LeetCode.Daily_Challenge.Easy.Check_If_a_Word_Occurs_As_a_Prefix_of_Any_Word_in_a_Sentence;

public class Solution {

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++)
            if (words[i].startsWith(searchWord))
                return i + 1;

        return -1;
    }
}
