package LeetCode.Top_Interview_150.Backtracking.Medium.Word_Search;

public class Solution {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (backtrack(board, i, j, word, 0)) return true;

        return false;
    }

    private static boolean backtrack(char[][] board, int i, int j, String word, int index) {
        if (index == word.length())
            return true;

        int m = board.length;
        int n = board[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != word.charAt(index))
            return false;

        char original = board[i][j];
        board[i][j] = '#';

        boolean result = backtrack(board, i + 1, j, word, index + 1) ||
                backtrack(board, i - 1, j, word, index + 1) ||
                backtrack(board, i, j + 1, word, index + 1) ||
                backtrack(board, i, j - 1, word, index + 1);

        board[i][j] = original;

        return result;
    }
}
