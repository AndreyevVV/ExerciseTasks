package LeetCode.Daily_Challenge.Medium.Find_the_Minimum_and_Maximum_Number_of_Nodes_Between_Critical_Points;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        ListNode head1 = new ListNode(3, new ListNode(1));
        printResult(head1, solution.nodesBetweenCriticalPoints(head1));

        // Example 2
        ListNode head2 = new ListNode(5, 
                        new ListNode(3, 
                        new ListNode(1, 
                        new ListNode(2, 
                        new ListNode(5, 
                        new ListNode(1, 
                        new ListNode(2)))))));
        printResult(head2, solution.nodesBetweenCriticalPoints(head2));

        // Example 3
        ListNode head3 = new ListNode(1, 
                        new ListNode(3, 
                        new ListNode(2, 
                        new ListNode(2, 
                        new ListNode(3, 
                        new ListNode(2, 
                        new ListNode(2, 
                        new ListNode(2, 
                        new ListNode(7)))))))));
        printResult(head3, solution.nodesBetweenCriticalPoints(head3));
    }
    
    private static void printResult(ListNode head, int[] result) {
        System.out.print("Input: head = [");
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            current = current.next;
            if (current != null) {
                System.out.print(",");
            }
        }
        System.out.print("]\nOutput: [");
        System.out.print(result[0] + "," + result[1]);
        System.out.println("]");
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return new int[]{-1, -1};

        int firstCriticalIndex = -1;
        int lastCriticalIndex = -1;
        int minDistance = Integer.MAX_VALUE;
        int index = 1;
        ListNode prev = head;
        ListNode curr = head.next;

        while (curr.next != null) {
            if ((curr.val > prev.val && curr.val > curr.next.val) || 
                (curr.val < prev.val && curr.val < curr.next.val)) {
                if (firstCriticalIndex == -1)
                    firstCriticalIndex = index;
                else
                    minDistance = Math.min(minDistance, index - lastCriticalIndex);
            
                lastCriticalIndex = index;
            }
            prev = curr;
            curr = curr.next;
            index++;
        }

        if (firstCriticalIndex == lastCriticalIndex)
            return new int[]{-1, -1};
    

        int maxDistance = lastCriticalIndex - firstCriticalIndex;
        return new int[]{minDistance, maxDistance};
    }
        
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }    
}
