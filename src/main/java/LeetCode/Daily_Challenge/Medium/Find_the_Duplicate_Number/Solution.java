package LeetCode.Daily_Challenge.Medium.Find_the_Duplicate_Number;

public class Solution {

    /*
    "Floyd's Tortoise and Hare Algorithm" for circular search in linked lists.
    This algorithm works based on the idea that if you think of an array as a sequence of pointers to the elements
    of the array (like a linked list), and if there is a duplicate in the array, then that list will contain a loop.
    The algorithm finds the entry point of the loop and then finds the starting point of the loop, which
    is the repeating number.
    */

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
