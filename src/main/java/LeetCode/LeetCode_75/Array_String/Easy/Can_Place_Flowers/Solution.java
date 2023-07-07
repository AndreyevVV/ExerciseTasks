package LeetCode.LeetCode_75.Array_String.Easy.Can_Place_Flowers;

public class Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0, length1 = flowerbed.length;
        int numberOfZeros;
        int spots = 0;
        if (length1 == 1) if (flowerbed[0] == 0) return n <= 1;

        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            spots++;
        }
        if (length1 >= 3 && flowerbed[length1 - 1] == 0
                && flowerbed[length1 - 2] == 0) {
            flowerbed[length1 - 1] = 1;
            spots++;
        }
        for (int j = 0; j < length1; j++) {
            if (flowerbed[j] == 1) {
                numberOfZeros = countZeros(i, j, flowerbed);
                if ((numberOfZeros & 1) == 1) {
                    spots += numberOfZeros / 2;
                } else {
                    spots += (numberOfZeros - 1) / 2;
                }
                i = j;
            }
        }
        return spots >= n;
    }

    public int countZeros(int i, int j, int[] flowerbed) {
        int numberOfZeros = 0;
        for (int k = i; k < j; k++) {
            if (flowerbed[k] == 0) numberOfZeros++;
        }
        return numberOfZeros;
    }
}
