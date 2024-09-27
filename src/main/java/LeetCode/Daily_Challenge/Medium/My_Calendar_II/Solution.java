package LeetCode.Daily_Challenge.Medium.My_Calendar_II;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    class MyCalendarTwo {
        private List<int[]> bookings;
        private List<int[]> doubleBookings;

        public MyCalendarTwo() {
            bookings = new ArrayList<>();
            doubleBookings = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for (int[] event : doubleBookings)
                if (Math.max(event[0], start) < Math.min(event[1], end))
                    return false;

            for (int[] event : bookings) {
                int overlapStart = Math.max(event[0], start);
                int overlapEnd = Math.min(event[1], end);
                if (overlapStart < overlapEnd)
                    doubleBookings.add(new int[]{overlapStart, overlapEnd});
            }

            bookings.add(new int[]{start, end});
            return true;
        }
    }

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
}
