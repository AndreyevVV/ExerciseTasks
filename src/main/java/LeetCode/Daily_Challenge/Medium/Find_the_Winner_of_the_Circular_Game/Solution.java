package LeetCode.Daily_Challenge.Medium.Find_the_Winner_of_the_Circular_Game;

public class Solution {

    public int findTheWinner(int n, int k) {
        return josephus(n, k) + 1;
    }

    private static int josephus(int n, int k) {
        int winner = 0;
        for (int i = 2; i <= n; i++)
            winner = (winner + k) % i;
        return winner;
    }
}
