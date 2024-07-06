package LeetCode.Daily_Challenge.Easy.Pass_the_Pillow;

public class Solution {

    public int passThePillow(int n, int time) {
        int position = 1;
        boolean forward = true;

        for (int i = 0; i < time; i++) {
            if (forward) {
                position++;
                if (position == n)
                    forward = false;
            } else {
                position--;
                if (position == 1)
                    forward = true;
            }
        }
        return position;
    }
}
