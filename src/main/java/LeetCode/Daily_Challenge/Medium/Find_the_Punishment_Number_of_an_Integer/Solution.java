package LeetCode.Daily_Challenge.Medium.Find_the_Punishment_Number_of_an_Integer;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.punishmentNumber(10)); // 182
        System.out.println(sol.punishmentNumber(37)); // 1478
    }

    public int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            if (canPartition(String.valueOf(square), 0, i))
                sum += square;
        }
        return sum;
    }

    private boolean canPartition(String s, int index, int target) {
        if (index == s.length())
            return target == 0;

        int num = 0;
        for (int j = index; j < s.length(); j++) {
            num = num * 10 + (s.charAt(j) - '0');
            if (num > target)
                break;
            if (canPartition(s, j + 1, target - num))
                return true;
        }
        return false;
    }
}
