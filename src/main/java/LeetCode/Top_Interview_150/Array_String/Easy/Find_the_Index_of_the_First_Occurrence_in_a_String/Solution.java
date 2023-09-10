package LeetCode.Top_Interview_150.Array_String.Easy.Find_the_Index_of_the_First_Occurrence_in_a_String;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().strStr("mississippi", "sipp"));
    }

    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (i + needle.length() <= haystack.length()) {
                    int j = 0, k = i;
                    while (j < needle.length()) {
                        if (needle.charAt(j++) == haystack.charAt(k++)) {
                            if (j == needle.length()) return i;
                        } else break;
                    }
                }
            }
        }
        return -1;
    }
}
