package LeetCode.Daily_Challenge.Medium.Count_Triplets_That_Can_Form_Two_Arrays_of_Equal_XOR;

public class Solution {

    public int countTriplets(int[] arr) {
        int n = arr.length;
        int count = 0;

        int[] prefixXOR = new int[n + 1];
        prefixXOR[0] = 0;

        for (int i = 0; i < n; i++)
            prefixXOR[i + 1] = prefixXOR[i] ^ arr[i];

        for (int i = 0; i < n; i++)
            for (int k = i + 1; k < n; k++)
                if (prefixXOR[i] == prefixXOR[k + 1])
                    count += (k - i);

        return count;
    }
}
