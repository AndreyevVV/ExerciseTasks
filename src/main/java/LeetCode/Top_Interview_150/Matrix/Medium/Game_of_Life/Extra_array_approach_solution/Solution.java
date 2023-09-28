package LeetCode.Top_Interview_150.Matrix.Medium.Game_of_Life.Extra_array_approach_solution;

public class Solution {

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] copyBoard = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = countLiveNeighbors(board, i, j);

                if (board[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3)
                        copyBoard[i][j] = 0;
                    else
                        copyBoard[i][j] = 1;
                } else {
                    if (liveNeighbors == 3)
                        copyBoard[i][j] = 1;
                    else
                        copyBoard[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++)
            System.arraycopy(copyBoard[i], 0, board[i], 0, n);
    }

    private int countLiveNeighbors(int[][] board, int row, int col) {
        int[][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        int liveCount = 0;
        int m = board.length;
        int n = board[0].length;

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n)
                if (board[newRow][newCol] == 1)
                    liveCount++;
        }
        return liveCount;
    }
}
