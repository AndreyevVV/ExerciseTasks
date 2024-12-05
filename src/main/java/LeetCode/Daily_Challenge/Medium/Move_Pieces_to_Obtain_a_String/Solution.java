package LeetCode.Daily_Challenge.Medium.Move_Pieces_to_Obtain_a_String;

public class Solution {

    public boolean canChange(String start, String target) {
        String startStripped = start.replace("_", "");
        String targetStripped = target.replace("_", "");
        if (!startStripped.equals(targetStripped))
            return false;

        int n = start.length();
        int startIndex = 0, targetIndex = 0;

        while (startIndex < n && targetIndex < n) {
            // Пропускаем символы '_'
            while (startIndex < n && start.charAt(startIndex) == '_')
                startIndex++;
            while (targetIndex < n && target.charAt(targetIndex) == '_')
                targetIndex++;

            if (startIndex == n && targetIndex == n)
                return true;

            if (startIndex == n || targetIndex == n)
                return false;

            char startChar = start.charAt(startIndex);
            char targetChar = target.charAt(targetIndex);

            if (startChar != targetChar)
                return false;

            if (startChar == 'L' && startIndex < targetIndex)
                return false;
            if (startChar == 'R' && startIndex > targetIndex)
                return false;

            startIndex++;
            targetIndex++;
        }

        return true;
    }
}
