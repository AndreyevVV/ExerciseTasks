package LeetCode.Daily_Challenge.Easy.Path_Crossing;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isPathCrossing("NESWW"));
    }

    public boolean isPathCrossing(String path) {
        Map<Character, int[]> directionMap = new HashMap<>();
        directionMap.put('N', new int[]{-1, 0});
        directionMap.put('S', new int[]{1, 0});
        directionMap.put('W', new int[]{0, -1});
        directionMap.put('E', new int[]{0, 1});

        Set<Point> visitedCoordinates = new HashSet<>();
        Point currentCoordinate = new Point(0, 0);
        visitedCoordinates.add(new Point(currentCoordinate.getX(), currentCoordinate.getY()));

        for (char direction : path.toCharArray()) {
            int[] step = directionMap.get(direction);

            currentCoordinate.x += step[0];
            currentCoordinate.y += step[1];

            if (!visitedCoordinates.add(new Point(currentCoordinate.getX(), currentCoordinate.getY())))
                return true;
        }
        return false;
    }

    public class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Point point = (Point) obj;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
