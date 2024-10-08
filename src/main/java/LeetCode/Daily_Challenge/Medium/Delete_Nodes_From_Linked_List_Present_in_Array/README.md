---
created: 2024-09-06T22:10:33 (UTC +03:00)
source: https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/description/?envType=daily-question&envId=2024-09-06
---
You are given an array of integers `nums` and the `head` of a linked list. Return the `head` of the modified linked list after **removing** all nodes from the linked list that have a value that exists in `nums`.


**Example 1:**

**Input:** nums = \[1,2,3\], head = \[1,2,3,4,5\]

**Output:** \[4,5\]

**Explanation:**

![img.png](img.png)

Remove the nodes with values 1, 2, and 3.


**Example 2:**

**Input:** nums = \[1\], head = \[1,2,1,2,1,2\]

**Output:** \[2,2,2\]

**Explanation:**

![img_1.png](img_1.png)

Remove the nodes with value 1.


**Example 3:**

**Input:** nums = \[5\], head = \[1,2,3,4\]

**Output:** \[1,2,3,4\]

**Explanation:**

![img_2.png](img_2.png)

No node has value 5.


**Constraints:**

-   `1 <= nums.length <= 10^5`
-   `1 <= nums[i] <= 10^5`
-   All elements in `nums` are unique.
-   The number of nodes in the given list is in the range `[1, 10^5]`.
-   `1 <= Node.val <= 10^5`
-   The input is generated such that there is at least one node in the linked list that has a value not present in `nums`.
