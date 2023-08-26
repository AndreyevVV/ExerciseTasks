package LeetCode.LeetCode_75.Bit_Manipulation.Easy.Counting_Bits;

public class Solution {

    public int[] countBits(int n) {
        int[] answer = new int[n + 1];

        for (int i = 0; i <= n; i++){
            int length = i, count = 0;
            while (length != 0){
                count += length & 1;
                length >>= 1;
            }
            answer[i] = count;
        }
        return answer;
    }
}
