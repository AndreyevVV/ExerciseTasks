package LeetCode.LeetCode_75_Level_1.Day_7_Binary_Search.Easy.First_Bad_Version;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
public class Solution {

    public int firstBadVersion(int n) {

        int l = 0, r = n;

        while ( l <= r) {

            int mid = l + ( r - l) / 2;

            if ( isBadVersion(mid) && !isBadVersion(mid - 1)) return mid;

            if (!isBadVersion(mid)) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }

    boolean isBadVersion(int version){return false;}
}
