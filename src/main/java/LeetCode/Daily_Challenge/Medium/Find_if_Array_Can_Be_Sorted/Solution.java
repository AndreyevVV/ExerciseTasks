package LeetCode.Daily_Challenge.Medium.Find_if_Array_Can_Be_Sorted;

public class Solution {

    public boolean canSortArray(int[] nums) {
        short previousMax = 0;
        short currentMin = 0;
        short currentMax = 0;
        byte previousBitCount = 0;

        for (final int value : nums) {
            byte currentBitCount = (byte) Integer.bitCount(value);

            if (previousBitCount == currentBitCount) {
                currentMin = (short) Math.min(currentMin, value);
                currentMax = (short) Math.max(currentMax, value);
            } else {
                if (currentMin < previousMax) {
                    return false;
                }
                previousMax = currentMax;
                currentMin = currentMax = (short) value;
                previousBitCount = currentBitCount;
            }
        }
        return currentMin >= previousMax;
    }
}
