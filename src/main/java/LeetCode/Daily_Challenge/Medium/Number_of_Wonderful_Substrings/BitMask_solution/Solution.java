package LeetCode.Daily_Challenge.Medium.Number_of_Wonderful_Substrings.BitMask_solution;

public class Solution {

    public long wonderfulSubstrings(String word) {
        int[] count = new int[1024]; // Array to store the count of substrings for each bitmask
        count[0] = 1; // Initial value, empty string
        int mask = 0; // Current bitmask
        long result = 0; // Result

        // Iterate through each character in the string
        for (char c : word.toCharArray()) {
            int index = 1 << (c - 'a'); // Get the index of the letter in the alphabet

            // Toggle the bit for the current letter
            mask ^= index;

            // Add to the result the count of substrings where all letters appear even number of times
            result += count[mask];

            // Add the count of substrings where exactly one letter appears odd number of times
            for (int i = 0; i < 10; i++) {
                result += count[mask ^ (1 << i)];
            }

            // Increment the count of substrings with the current bitmask
            count[mask]++;
        }

        return result;
    }
}
