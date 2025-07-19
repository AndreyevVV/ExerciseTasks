package LeetCode.Daily_Challenge.Medium.Remove_SubFolders_from_the_Filesystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();

        String prev = "";
        for (String path : folder) {
            if (prev.isEmpty() || !path.startsWith(prev + "/")) {
                result.add(path);
                prev = path;
            }
        }

        return result;
    }
}
