package LeetCode.Daily_Challenge.Medium.My_Calendar_I;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    class MyCalendar {
        private List<int[]> calendar;

        public MyCalendar() {
            calendar = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for (int[] event : calendar)
                if (Math.max(event[0], start) < Math.min(event[1], end))
                    return false;

            calendar.add(new int[]{start, end});
            return true;
        }
    }

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
}
