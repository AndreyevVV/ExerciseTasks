package LeetCode.LeetCode_75.Two_Pointers.Medium.Container_With_Most_Water;

public class Solution {

    public int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;

        int leftBorderIndex = 0, rightBorderIndex = height.length - 1;
        int maxArea = (rightBorderIndex - leftBorderIndex)
                * Math.min(height[leftBorderIndex], height[rightBorderIndex]);

        while (leftBorderIndex < rightBorderIndex) {
            int bottom = rightBorderIndex - leftBorderIndex;
            int leftBorder = height[leftBorderIndex], rightBorder = height[rightBorderIndex];

            maxArea = Math.max(maxArea, bottom * Math.min(leftBorder, rightBorder));

            if (height[leftBorderIndex] <= height[rightBorderIndex]) leftBorderIndex++;
            else rightBorderIndex--;
        }
        return maxArea;
    }
}
