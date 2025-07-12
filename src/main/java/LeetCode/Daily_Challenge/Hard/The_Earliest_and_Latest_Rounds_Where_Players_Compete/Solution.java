package LeetCode.Daily_Challenge.Hard.The_Earliest_and_Latest_Rounds_Where_Players_Compete;

public class Solution {
     public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        int a = Math.min(firstPlayer, secondPlayer);
        int b = Math.max(firstPlayer, secondPlayer);

        if (a + b == n + 1) return new int[] {1, 1};

        if (n == 3 || n == 4) return new int[] {2, 2};

        if (a - 1 > n - b) {
            int temp = n + 1 - a;
            a = n + 1 - b;
            b = temp;
        }

        int nextRoundSize = (n + 1) / 2;
        int minRound = n;
        int maxRound = 1;

        if (b * 2 <= n + 1) {
            int leftGap = a - 1;
            int midGap = b - a - 1;
            for (int i = 0; i <= leftGap; i++) {
                for (int j = 0; j <= midGap; j++) {
                    int nextA = i + 1;
                    int nextB = i + j + 2;
                    int[] res = earliestAndLatest(nextRoundSize, nextA, nextB);
                    minRound = Math.min(minRound, 1 + res[0]);
                    maxRound = Math.max(maxRound, 1 + res[1]);
                }
            }
        } else {
            int mirrorB = n + 1 - b;
            int leftGap = a - 1;
            int midGap = mirrorB - a - 1;
            int innerGap = b - mirrorB - 1;

            for (int i = 0; i <= leftGap; i++) {
                for (int j = 0; j <= midGap; j++) {
                    int nextA = i + 1;
                    int nextB = i + j + 2 + (innerGap + 1) / 2;
                    int[] res = earliestAndLatest(nextRoundSize, nextA, nextB);
                    minRound = Math.min(minRound, 1 + res[0]);
                    maxRound = Math.max(maxRound, 1 + res[1]);
                }
            }
        }

        return new int[] {minRound, maxRound};        
    }
}
