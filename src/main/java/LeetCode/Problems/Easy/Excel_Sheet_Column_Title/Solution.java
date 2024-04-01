package LeetCode.Problems.Easy.Excel_Sheet_Column_Title;

public class Solution {

    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            int remainder = (columnNumber - 1) % 26;
            char digit = (char) ('A' + remainder);
            result.insert(0, digit);
            columnNumber = (columnNumber - 1) / 26;
        }
        return result.toString();
    }
}
