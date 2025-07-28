package LeetCode.Daily_Challenge.Medium.Maximum_Score_From_Removing_Substrings.Alter_Solution;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "cdbcbbaaabab";
        int x = 4; // очки за удаление "ab"
        int y = 5; // очки за удаление "ba"

        int result = solution.maximumGain(s, x, y);
        System.out.println("Максимальное количество очков: " + result);
    }
    
    public int maximumGain(String s, int x, int y) {
        if (x >= y) {
            Result r1 = removePairs(s, 'a', 'b', x);
            Result r2 = removePairs(r1.str, 'b', 'a', y);
            return r1.score + r2.score;
        } else {
            Result r1 = removePairs(s, 'b', 'a', y);
            Result r2 = removePairs(r1.str, 'a', 'b', x);
            return r1.score + r2.score;
        }
    }

    private Result removePairs(String s, char first, char second, int points) {
        StringBuilder sb = new StringBuilder();
        int score = 0;
        for (char c : s.toCharArray()) {
            sb.append(c);
            int len = sb.length();
            if (len >= 2 && sb.charAt(len - 2) == first && sb.charAt(len - 1) == second) {
                sb.delete(sb.length() - 2, sb.length());
                score += points;
            }
        }
        return new Result(sb.toString(), score);
    }

    private static class Result {
        String str;
        int score;
        Result(String str, int score) {
            this.str = str;
            this.score = score;
        }
    }
}
