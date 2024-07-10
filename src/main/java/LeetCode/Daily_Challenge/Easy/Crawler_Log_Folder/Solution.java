package LeetCode.Daily_Challenge.Easy.Crawler_Log_Folder;

public class Solution {

    public int minOperations(String[] logs) {
        int depth = 0;

        for (String log : logs) {
            if (log.equals("../")) {
                if (depth > 0)
                    depth--;
            } else if (!log.equals("./"))
                depth++;
        }
        return depth;
    }
}
