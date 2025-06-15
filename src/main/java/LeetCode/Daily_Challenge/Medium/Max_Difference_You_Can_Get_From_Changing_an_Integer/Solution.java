package LeetCode.Daily_Challenge.Medium.Max_Difference_You_Can_Get_From_Changing_an_Integer;

public class Solution {

    public int maxDiff(int num) {
        String s = String.valueOf(num);

        char[] maxChars = s.toCharArray();
        char toReplaceMax = ' ';
        for (char c : maxChars) {
            if (c != '9') {
                toReplaceMax = c;
                break;
            }
        }

        StringBuilder maxStr = new StringBuilder();

        for (char c : maxChars)
            maxStr.append(c == toReplaceMax ? '9' : c);

        char[] minChars = s.toCharArray();
        char toReplaceMin = ' ';
        char replaceWithMin = ' ';
        if (minChars[0] != '1') {
            toReplaceMin = minChars[0];
            replaceWithMin = '1';
        } else {
            for (int i = 1; i < minChars.length; i++) {
                if (minChars[i] != '0' && minChars[i] != '1') {
                    toReplaceMin = minChars[i];
                    replaceWithMin = '0';
                    break;
                }
            }
        }

        StringBuilder minStr = new StringBuilder();
        for (char c : minChars) {
            minStr.append(c == toReplaceMin ? replaceWithMin : c);
        }

        int a = Integer.parseInt(maxStr.toString());
        int b = Integer.parseInt(minStr.toString());

        return a - b;
    }
}
